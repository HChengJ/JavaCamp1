package org.hcj.spring.Work.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Student.class)
@EnableConfigurationProperties(Student.class)
public class StudentAutoConfiguration {
    @Autowired
    Student student;

    @Bean
    @ConditionalOnMissingBean(Student.class)
    @ConditionalOnProperty(prefix = "msg", value = "enabled", havingValue = "true")
    public Student msgService() {
        Student msgService = new Student("111");
        return msgService;
    }

}
