package com.free.ldmspringbooot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.free.*")
public class LdmSpringboootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdmSpringboootApplication.class, args);
	}
}
