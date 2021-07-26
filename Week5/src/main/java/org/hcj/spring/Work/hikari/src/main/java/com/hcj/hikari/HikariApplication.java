package com.hcj.hikari;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class HikariApplication {

	public static void main(String[] args) {
//		SpringApplication.run(HikariApplication.class, args);
		SpringApplication bootstrap = new SpringApplication(HikariApplication.class);
		bootstrap.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
				// 比如打印一个我们喜欢的ASCII Arts字符画
			}
		});
		bootstrap.setBannerMode(Banner.Mode.CONSOLE);
		// 其他定制设置...
		bootstrap.run(args);

	}

}
