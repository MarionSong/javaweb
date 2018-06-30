package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ec/")
public class ExceptionController {
	@RequestMapping("doMethod01")
	@ResponseBody
	public String doMethod01(Integer a,Integer b) {

		return "result is"+(a/b);
		
	}
	/**
	 * ExceptionHandler修饰的方法为一个异常
	 * @param n
	 * @return
	 */
	/*@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public String doHandleExp01(NullPointerException n) {
		return "input is null";
	}*/
/*	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleExp02(RuntimeException n) {
		return "error";
	}*/
	
	
}
