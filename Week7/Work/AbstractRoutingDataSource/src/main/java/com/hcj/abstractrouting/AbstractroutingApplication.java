package com.hcj.abstractrouting;

import com.hcj.abstractrouting.util.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@MapperScan("com.hcj.abstractrouting.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class AbstractroutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbstractroutingApplication.class, args);
	}

}
