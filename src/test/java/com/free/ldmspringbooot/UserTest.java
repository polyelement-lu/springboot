package com.free.ldmspringbooot;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.free.web.UserController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	@Test
	public void userController() throws Exception{
		RequestBuilder request = null;
		request = get("/users/");
		// 1.检查user列表，为null
		mvc.perform(request).andExpect(status().isOk())
							.andExpect(content().string(equalTo("[]")));
		// 2.post提交User
		request = post("/users/").param("id","1")
								.param("name", "用户测试")
								.param("age", "26");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 3.获取user列表
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
							.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"用户测试\",\"age\":26}]")))
							.andDo(print());// 打印信息
		// 4.put修改id为1的user
		request = put("/users/1").param("name", "用户测试1")
				                 .param("age", "30");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 5.get获取id为1的user
		request = get("/users/1");
		mvc.perform(request).andExpect(status().isOk())
							.andExpect(content().string("{\"id\":1,\"name\":\"用户测试1\",\"age\":30}"));
		// 6.删除id为1的user
		request = delete("/users/1");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		// 7.检查user列表，应该为空
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
							.andExpect(content().string(equalTo("[]")));
	}
}
