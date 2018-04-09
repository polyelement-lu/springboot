package com.free.ldmspringbooot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.free.service.properties.BlogProPerties;
import com.free.web.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LdmSpringboootApplicationTests {
	
	private MockMvc mvc;
	
	@Autowired
	private BlogProPerties blogProPerties;
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	@Test
	public void getHello() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}
	@Test
	public void getBlog() throws Exception{
		System.err.println(blogProPerties.getName());
		System.err.println(blogProPerties.getTitle());
		System.err.println(blogProPerties.getDesc());
		System.err.println(blogProPerties.getValue());
		System.err.println(blogProPerties.getNumber());
		System.err.println(blogProPerties.getBignumber());
		System.err.println(blogProPerties.getTest1());
		System.err.println(blogProPerties.getTest2());
	}
}
