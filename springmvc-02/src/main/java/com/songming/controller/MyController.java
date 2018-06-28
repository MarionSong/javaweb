package com.songming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/res/")
public class MyController {
	
	@RequestMapping("request01")
	public ModelAndView request01() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("request01");
		return mv;
	}
	
	
	
}
