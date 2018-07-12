package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";//starter.html
	}
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
}




