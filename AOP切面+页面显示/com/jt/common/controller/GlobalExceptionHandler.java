package com.jt.common.controller;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
/**
 * 全局异常处理类
 * @author 速度
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AuthenticationException.class)
	@ResponseBody
	public JsonResult doAuthentication(ShiroException e) {
		if(e instanceof IncorrectCredentialsException) {
			return new JsonResult(0,"用户名或密码不正确");
		}else if(e instanceof AuthorizationException ) {
			return new JsonResult(0,"你没有权限执行此操作");
		}
		return new JsonResult(e);
	}



	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
