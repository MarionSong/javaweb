package com.jt.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @ControllerAdvice 修饰的类表示全局异常处理类
 * @author cgb1803
 *
 */
@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String dohandleExp(Exception e) {
		e.printStackTrace();
		return "error";
		
	}
}
