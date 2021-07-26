package com.hcj.hikari;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentAction {
    @Autowired
    StudentService studentService;


    @RequestMapping("/add")
    public String add() {
        Student bean = new Student();
        bean.setName("111");
        studentService.addOrUpdate(bean);
        return "新增用户组";
    }

    @RequestMapping("/find")
    public String find() {
        List<Student> list = studentService.findAll();
        return list == null ? "查无讯息" : list.size()+"";
    }

    @RequestMapping("/delete")
    public String delete(Student bean) {
        studentService.delete(bean);
        return "删除用户组";
    }

}
