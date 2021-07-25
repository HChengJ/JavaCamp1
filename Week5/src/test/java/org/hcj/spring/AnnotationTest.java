package org.hcj.spring;

import org.hcj.spring.Work.Annotation.Student2Action;
import org.hcj.spring.Work.Java.IStudent3;
import org.hcj.spring.Work.Java.Student3;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

public class AnnotationTest {
    @Autowired
    private Student3 iStudent3;


    @Test
    public void test() {
        // 初始化Spring容器，加载配置文件，并对bean进行实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获得personAction实例
        Student2Action student2Action = (Student2Action) applicationContext
                .getBean("student22Action");
        // 调用personAction中的add()方法
        student2Action.read();

        iStudent3.read3();;

    }
}
