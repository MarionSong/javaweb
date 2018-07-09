package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
	  @RequestMapping("doIndexUI")
	  public String doindexUI(){
		  return "starter";
	  }//首页页面
	  
	  @RequestMapping("doPageUI")
		public String doPageUI(){
			return "common/page";
		}
}
