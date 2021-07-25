package org.hcj.spring.Work;

import org.hcj.spring.Work.Case.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Autowired
    Student student;

    @Bean
    public void tt(){
        System.out.println(student.getName());
    }


}
