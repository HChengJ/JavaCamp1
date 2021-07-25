package org.hcj.spring.Work.Java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Student3Config {
    @Bean
    public IStudent3 getStudent3() {
        return new Student3();
    }

}
