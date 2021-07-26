package com.hcj.hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public List findAll(){
        return  studentDao.findAll();
    }

    public Student addOrUpdate(Student student){
        return (Student) studentDao.save(student);
    }

    public void delete(Student student){
        studentDao.delete(student);
    }
}
