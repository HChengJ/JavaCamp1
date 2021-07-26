package org.hcj.spring.Work.JDBC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DefaultStudentDao implements  StudentDao{
    @Autowired
    private DataSource dataSource;//hikariCP

    @Override
    public List<Map<String,Object>> findAll() {
        Connection conn=null;//java.sql.*
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select * from student";
        //1.获取连接(从连接池获取)
        try {
            conn= (Connection) dataSource.getConnection();
            //2.创建statement对象
            stmt= (Statement) conn.createStatement();
            //3.发送sql
            rs=stmt.executeQuery(sql);
            //4.处理结果
            List<Map<String,Object>> list=new ArrayList<>();
            while(rs.next()){//循环一次取一行,一行记录映射为一个map对象
                list.add( rowMap(rs));//将存储了一行记录的map对象再存储到list集合
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);//转换为非检查异常(编译时不检测的异常)
        }finally{
            //5. 释放资源
            close(rs,stmt,conn);
        }
    }

    private Map<String,Object> rowMap(ResultSet rs)throws SQLException{
        Map<String,Object> rowMap=new HashMap<>();
        //方法1映射
        //rowMap.put("id",rs.getInt("id"));
        //rowMap.put("name",rs.getString("name"));
        //rowMap.put("remark",rs.getString("remark"));
        //rowMap.put("createdTime",rs.getTimestamp("createdTime"));
        //方法2映射
        ResultSetMetaData rsmd=rs.getMetaData();//获取元数据(包括表中的字段名)
        int columnCount=rsmd.getColumnCount();//获取列的数量
        for(int i=0;i<columnCount;i++){
            rowMap.put(rsmd.getColumnLabel(i+1),rs.getObject(rsmd.getColumnLabel(i+1)));
            //getColumnLabel(i+1);获取表中字段名或字段名对应的别名
        }
        return rowMap;
    }
    private void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null)try{rs.close();}catch(Exception e){e.printStackTrace();}
        if(stmt!=null)try{stmt.close();}catch(Exception e){e.printStackTrace();}
        //这里的连接是返回到了池中
        if(conn!=null)try{conn.close();}catch(Exception e){e.printStackTrace();}
    }

}
