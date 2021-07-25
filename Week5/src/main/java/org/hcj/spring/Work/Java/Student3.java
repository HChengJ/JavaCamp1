package org.hcj.spring.Work.Java;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student3 implements IStudent3{

    @Override
    public void read3() {
        System.out.println("Student3-read3");
    }
}
