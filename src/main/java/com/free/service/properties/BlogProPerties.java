package com.free.service.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 
 * @author      ludm  
 * @date        2018年4月4日下午3:34:29 
 * @description 加载对应的属性配置
 */
@Component
// 设置前缀，属性上不用再添加注解
@ConfigurationProperties(prefix="com.free.blog")
public class BlogProPerties {
//	@Value("${com.free.blog.name}")
	private String name;
	
//	@Value("${com.free.blog.title}")
	private String title;
	
//	@Value("${com.free.blog.desc}")
	private String desc;
	
//	@Value("${com.free.blog.value}")
	private String value;
	
//	@Value("${com.free.blog.number}")
	private String number;
	
//	@Value("${com.free.blog.bignumber}")
	private String bignumber;
	
//	@Value("${com.free.blog.test1}")
	private String test1;
	
//	@Value("${com.free.blog.test2}")
	private String test2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBignumber() {
		return bignumber;
	}
	public void setBignumber(String bignumber) {
		this.bignumber = bignumber;
	}
	public String getTest1() {
		return test1;
	}
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}

}
