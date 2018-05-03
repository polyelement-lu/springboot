package com.free.ldmspringbooot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author      ludm  
 * @date        2018年5月2日下午1:52:35 
 * @description @Profile({"dev","test"})生产环境不开启
 */
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix="swagger",value={"enable"},havingValue="true")
//@Profile({"dev","test"})
public class SwaggerConfig {
	/**
	 * 是否开启swagger
	 * 1.直接注解@Profile({"dev","test"})
	 * 2.直接注解@ConditionalOnProperty(prefix="swagger",value={"enable"},havingValue="true")
	 * +resource配置（swagger.enable = true）
	 * 3.resource配置（swagger.enable = true）+@Value("${swagger.enable}")取值（建议）
	 */
	@Value("${swagger.enable}")
	private boolean enableSwagger;
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.enable(enableSwagger)// 是否开启swagger
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.free.web"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Spring Boot使用SWAGGER_2构建RESTful Api")
				.description("详情请关注：http://www.baidu.com")
				.termsOfServiceUrl("http://www.baidu.com")
				.contact(new Contact("测试QWER-TEST", "http://www.baidu.com", "1207671714@qq.com"))
				.version("1.0")
				.build();
	}
}
