package com.jt.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resp")
public class HandleResponseController {
	
	
	@RequestMapping("doHandleResponse01")
	@ResponseBody
	public Map<String,Object> doHandleResponse01(){
		
		Map<String, Object> map = new HashMap<>();
		map.put("id",100);
		map.put("title", "titlea");
		return map;
		
		
		
	}
	
	
	
	
}
