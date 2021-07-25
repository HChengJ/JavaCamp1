package org.hcj.spring.Work.JDBC;

import com.mysql.jdbc.Statement;

import java.sql.*;

public class JDBCUtil {
    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
// CREATE TABLE test.student ( id BIGINT(20) NOT NULL AUTO_INCREMENT, NAME VARCHAR(200), PRIMARY KEY (id) );
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JDBCUtil jdbcUtil=new JDBCUtil();
        jdbcUtil.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&characterEncoding=utf8");
        jdbcUtil.setUsername("root");
        jdbcUtil.setPassword("root");
//        1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(jdbcUtil.getUrl(), jdbcUtil.getUsername(), jdbcUtil.getPassword());
        //3.操作数据库，实现增删改查
        //预编译SQL，减少sql执行
        String sql="INSERT INTO student (name) VALUES ('suveng')";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();

        ResultSet rs2 = stmt.executeQuery("SELECT * FROM student");
        //如果有数据，rs.next()返回true
        while(rs2.next()){
            System.out.println(rs2.getString("name"));
        }

        stmt.execute("delete from student where name ='suveng' ");
        System.out.println("删除完成");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
