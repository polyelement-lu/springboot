package com.free.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String index(ModelMap model) {
		model.addAttribute("host","http://www.baidu.com");
		return "index";
	}
	@RequestMapping("/demo")
	public String demo(ModelMap model) {
		model.addAttribute("host","百度一下");
		return "demo";
	}
}
