package org.hcj.spring.Work.Java;

import org.hcj.spring.Work.Annotation.Student2Service;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("student3Action")
public class Student3Action {
    @Resource
    private Student3 student3;

    public void read(){
        student3.read3();
        System.out.println("Student3Action-read3");
    }
}
