package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.mail.mapping")
//@EnableDiscoveryClient
public class SpringMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}
}
