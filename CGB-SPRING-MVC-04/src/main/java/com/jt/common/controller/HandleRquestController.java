package com.jt.common.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.entity.Message;

@Controller
@RequestMapping("/req")
public class HandleRquestController {
	/**
	 * 请求路径的普通URL映射
	 * @return
	 */
	
	@RequestMapping(value= {"doHeadleUrl01","doHeadleUrl02"})
	@ResponseBody
	public String doHandleRquest01() {
		return "doHandleRequest" ;
	}
	/**
	 * 请求路径的rest风格的映射,{}为rest表达式，类似于通配符,
	 * 当有精确匹配(普通URL映射)和模糊匹配的URL相同时，精确匹配的优先级更高
	 * @return
	 */
	@RequestMapping( "rest/{d}")
	@ResponseBody
	public String doHandleRequest02() {
		return "doHandleRequest02";
	}
	/**
	 * 此方法只能处理get请求
	 * @return
	 */
	@RequestMapping(value="doHandleRequest03",method= RequestMethod.GET)
	@ResponseBody
	public String doHandleRequest03() {
		
		return "doHandleRequest03";
		
	}
	/**
	 * 简化上个方法
	 * @return
	 */
	@GetMapping(value="doHandleRequest04")
	@ResponseBody
	public String doHandleRequest04() {
		
		return "doHandleRequest04";
		
	}
	
	/**
	 * 原生servletAPI方法
	 * @return
	 */
	@GetMapping(value="doHandleRequest05")
	@ResponseBody
	public String doHandleRequest05(HttpServletRequest request) {
		String parameter=request.getParameter("pageCurrent");
		return "doHandleRequest05"+parameter;
		
	}

	
	/**
	 * 使用直接量接收或处理请求参数
	 * 直接量=8种对象类型+字符串
	 * @return
	 */
	@GetMapping(value="doHandleRequest06")
	@ResponseBody
	public String doHandleRequest06(@RequestParam(value="page-Current",required=true)
			Integer pageCurrent,String msg,@DateTimeFormat(pattern="yyyy-MM-dd")Date date) {
		
		return "doHandleRequest6,pageCurrent="+pageCurrent+",msg="+msg+",date="+date;
		
	}//当客户端传递的数据不符合服务端数据格式及内容要求会报400异常
	
	@GetMapping(value="doHandleRequest07")
	@ResponseBody
	public String doHandleRequest07(Date date,@DateTimeFormat(pattern="yyyy-MM-dd")Date date1) {
		
		return "doHandleRequest6,date"+date+"date1="+date1;
		
	}//是谁将字符转换为了日期
	
	/***
	 * 使用javabean对象接收请求参数数据
	 * 注意请求参数名与bean对象的set方法保持一致
	 * @param msg
	 * @return
	 */
	@RequestMapping("doHandleRequest08")
	@ResponseBody
	public String daHandleRequest08(Message msg) {
		
		return "doHandleRequest08,msg"+msg;
		
		
	}
	/**
	 * 当使用参数接收rest风格URL中的数据时，通过@pathvariable注解进行修饰
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/daHandleRequest09/{id}")
	@ResponseBody
	public String daHandleRequest09(@PathVariable Integer id) {		
		return "doHandleRequest09,id="+id;

	}
	
	@RequestMapping(value="/daHandleRequest10",method=RequestMethod.GET)
	@ResponseBody
	public String daHandleRequest10(@RequestHeader(value="Accept-Encoding") String Accept) {		
		return "Obtained 'Accept' header '" + Accept+ "'";

	}
	
	@RequestMapping(value="/daHandleRequest11",
					produces="text/html;charset=utf-8")
	@ResponseBody
	public String daHandleRequest11(@CookieValue String JSESSIONID) {		
		return "Obtained COOKIE Value '" + JSESSIONID + "'";

	}
	
	
	
	
	
	
}
