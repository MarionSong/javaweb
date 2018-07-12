package com.jt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.sys.service.SystemService;

@Controller
@RequestMapping("/sys/")
public class SystemController {
	@Autowired
	private SystemService systemService;
	@RequestMapping("find")
	@ResponseBody
	public JsonResult find() {
		return new JsonResult(systemService.find());
	}
	
}
