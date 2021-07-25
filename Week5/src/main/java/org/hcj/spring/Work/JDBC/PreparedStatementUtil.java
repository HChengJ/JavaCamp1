package org.hcj.spring.Work.JDBC;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUtil {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&characterEncoding=utf8",
                "root", "root");

        //新增
        conn.setAutoCommit(false);//将自动提交关闭
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student (name) VALUES (?)");

        for(int i=0; i<10; i++){
            pstmt.setString(1, "a"+i);
            pstmt.addBatch();

            if(i>0 && i%10==0){
                pstmt.executeBatch();
                conn.commit();
            }
        }
        pstmt.executeBatch();
        pstmt.close();
        conn.commit();
         //修改
        PreparedStatement pstmt2 = conn.prepareStatement("update student set name=? where name like 'a%' ");
        for(int i=0; i<5; i++){
            pstmt2.setString(1, "b"+i);
            pstmt2.addBatch();

            if(i>0 && i%5==0){
                pstmt2.executeBatch();
                conn.commit();
            }
        }
        pstmt2.executeBatch();
        pstmt2.close();
        conn.commit();

        //删除
        PreparedStatement pstmt3 = conn.prepareStatement("delete from student where name like '%b%' ");
        for(int i=0; i<5; i++){
            pstmt3.addBatch();

            if(i>0 && i%5==0){
                pstmt3.executeBatch();
                conn.commit();
            }
        }
        pstmt3.executeBatch();
        pstmt3.close();
        conn.commit();



        conn.setAutoCommit(true);
        conn.close();
    }
}
