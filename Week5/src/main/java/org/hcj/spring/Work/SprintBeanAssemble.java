package org.hcj.spring.Work;

import org.hcj.spring.Work.Annotation.Student2Action;
import org.hcj.spring.Work.Automation.IStudent4;
import org.hcj.spring.Work.Automation.Student4;
import org.hcj.spring.Work.Automation.Student4Action;
import org.hcj.spring.Work.Java.IStudent3;
import org.hcj.spring.Work.Java.Student3;
import org.hcj.spring.Work.Java.Student3Action;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintBeanAssemble {
    private static IStudent3 iStudent3 = new Student3();
    @Autowired
    private static IStudent4 iStudent4;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //XML方式装配
        System.out.println("XML方式装配:");
        System.out.println(context.getBean("student1"));
        //Annotation方式装配
        Student2Action student2Action = (Student2Action) context.getBean("student22Action");
        System.out.println("Annotation方式装配:");
        student2Action.read();
        //Java代码装配
        System.out.println("Java代码方式装配:");
        Student3Action student3Action = (Student3Action) context.getBean("student3Action");
        student3Action.read();
        //自动化装配
        System.out.println("自动化装配:");
        Student4Action student4Action = (Student4Action) context.getBean("student4Action");
        student4Action.read();
    }


}
