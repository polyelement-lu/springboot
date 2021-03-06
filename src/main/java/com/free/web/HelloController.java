package com.free.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HelloController {
	@RequestMapping("/hello")
	public String index(ModelMap model) {
		model.addAttribute("host","http://www.baidu.com");
		return "test";
	}
	@RequestMapping("/demo")
	public String demo(ModelMap model) {
		model.addAttribute("host","百度一下");
		return "demo";
	}
//	@RequestMapping("/except/deal")
//	public String error() throws Exception{
//		throw new Exception("发生错误");
//	}
	@RequestMapping("/json")
	public String error() throws Exception{
		throw new Exception("发生错误");
	}
}
