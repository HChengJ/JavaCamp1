package org.hcj.spring.Work.Automation;


import org.springframework.stereotype.Component;

@Component
public class Student4 implements IStudent4 {
    @Override
    public void read4() {
        System.out.println("Student4=read4");
    }
}
