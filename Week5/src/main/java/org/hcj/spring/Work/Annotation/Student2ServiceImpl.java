package org.hcj.spring.Work.Annotation;

import org.springframework.stereotype.Service;

@Service("student22ServiceImpl")
public class Student2ServiceImpl implements Student2Service{
    @Override
    public void read2() {
        System.out.println("Student2ServiceImpl- read2()");
    }
}
