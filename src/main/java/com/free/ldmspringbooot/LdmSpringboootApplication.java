package com.free.ldmspringbooot;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ComponentScan(basePackages="com.free.*")
public class LdmSpringboootApplication {
	
	private static Logger logger = LoggerFactory.getLogger(LdmSpringboootApplication.class);
	
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication springApplication = new SpringApplication(LdmSpringboootApplication.class);
		// 禁止命令行设置参数
		springApplication.setAddCommandLineProperties(false);
		ConfigurableApplicationContext run = springApplication.run(args);
		
		ConfigurableEnvironment environment = run.getEnvironment();
		// InetAddress.getLocalHost().getHostAddress()本机ip地址
		logger.info("\n----------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"Local: \t\thttp://localhost:{}\n\t" +
				"External: \thttp://{}:{}\n\t"+
				"onDoc-External: \thttp://{}:{}/{}\n"+
				"----------------------------------------------------------",
				environment.getProperty("com.free.blog.name"),
				environment.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				environment.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				environment.getProperty("server.port"),
				environment.getProperty("doc.suffix"));
	}
}
