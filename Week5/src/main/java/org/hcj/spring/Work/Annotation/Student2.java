package org.hcj.spring.Work.Annotation;

import org.springframework.stereotype.Repository;

@Repository("student22")
public class Student2 implements IStudent2 {
    @Override
    public void read() {
        System.out.println("read.....");
    }
}
