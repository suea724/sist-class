package com.test.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//<context:component-scan base-package="com.test.spring" />

//@ComponentScan(basePackages = "com.test.spring")
//@ComponentScan(basePackages = "com.test.controller")
//@ComponentScan(basePackages = "com.test.service")
//@ComponentScan(basePackages = "com.test.repository")
//@ComponentScan(basePackages = {"com.test.controller", "com.test.service", "com.test.repository"})
//@ComponentScan(basePackages = "com.test.*")


@SpringBootApplication
@ComponentScan(basePackages = {"com.test.controller", "com.test.repository"})
public class BootMybatisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BootMybatisApplication.class, args);
	}

}








