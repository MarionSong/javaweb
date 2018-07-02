package com.jt.common.exp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return "haha";
	}
	
	
}
