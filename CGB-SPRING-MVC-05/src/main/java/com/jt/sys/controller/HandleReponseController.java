package com.jt.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/resp/")
public class HandleReponseController {
	
	@RequestMapping("doHandle")
	@ResponseBody
	public String doHandle(){
		Map<String,Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("name", "songming");
		return JSON.toJSONString(map);
		
	}
	@RequestMapping(value="doHandle01",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> doHandle01(){
		Map<String,Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("name", "宋铭");
		return map;
		
	}
	
}
