package org.hcj.spring.Work.Automation;

import org.hcj.spring.Work.Java.Student3;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("student4Action")
public class Student4Action {
    @Resource
    private Student4 student4;

    public void read(){
        student4.read4();
        System.out.println("Student4Action-read4");
    }
}
