package com.songming.juice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.songming.juice.dao.JuiceDao;
import com.songming.juice.pojo.Juice;
import com.songming.juice.service.JuiceService;
@Controller("juiceController")
public class JuiceController {
	@Autowired
	private JuiceService juiceService;

	public Juice findById(Integer id) {
		if(id==null||id<1) {
			throw new IllegalArgumentException("无效的参数");
		}
		Juice juice = juiceService.findById(id);
		if(juice==null) {
			throw new RuntimeException("记录不存在");
		}
		return juice;
	}
}
