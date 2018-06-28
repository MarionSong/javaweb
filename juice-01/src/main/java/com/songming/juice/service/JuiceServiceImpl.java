package com.songming.juice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songming.juice.dao.JuiceDao;
import com.songming.juice.pojo.Juice;

@Service("juiceServiceImpl")
public class JuiceServiceImpl implements JuiceService{
	@Autowired
	private JuiceDao juiceDao;

	@Override
	public Juice findById(Integer id) {
		if(id==null||id<1) {
			throw new IllegalArgumentException("无效的参数");
		}
		Juice juice = juiceDao.findById(id);
		if(juice==null) {
			throw new RuntimeException("记录不存在");
		}
		return juice;
	}
	
	
	
}
