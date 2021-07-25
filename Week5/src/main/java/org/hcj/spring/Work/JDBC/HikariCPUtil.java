package org.hcj.spring.Work.JDBC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;



//不停报错,无法完成
//不停报错,无法完成
//不停报错,无法完成
@SpringBootTest
public class HikariCPUtil {

//    @Autowired
//    private DataSource dataSource; //请问这个dataSource指向的具体对象是谁
//    @Test
//    public void testGetConnection() throws SQLException {
//        //获取dataSource变量指向的对象的具体类型的名字
//        //com.zaxxer.hikari.HikariDataSource
//        System.out.println(dataSource.getClass().getName());
//        //请问,通过dataSource获取连接的大概过程是怎样的?
//        //1.通过dataSource获取连接池(连接池不存在时则创建池)-HikariPool-->ConnectionBag-->CopyOnWriteArrayList
//        //2.底层基于jdbc获取与数据库的连接,并将连接存储到池中
//        //3.返回池中连接.
//        Connection conn = dataSource.getConnection();
//        System.out.println(conn); //HikariProxyConnection@1865982601
//    }
}
