package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {
	
	
	@RequestMapping("doSayWelcome")
	@ResponseBody//将方法的返回值以普通字符串的形式输出
	public String doSayWelcome() {
		
		return "do";
	}
	
	@RequestMapping("doSayHello")
	public String doSayHello() {
		return "hello";//不用那个注解，返回一个view
		
	}
	
	
}
