package org.hcj.spring.Work.Annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("student22Action")
public class Student2Action {
    @Resource
    private Student2Service student2Service;

    public void read(){
        student2Service.read2();
        System.out.println("student22Action-read执行了");
    }
}
