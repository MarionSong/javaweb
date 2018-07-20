package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.service.BaseService;
import com.jt.manage.mapper.UserMapper;
import com.jt.manage.pojo.User;
@Service
public class UserServiceImpl extends BaseService<User> implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> queryAll(){
		List<User> userList = userMapper.findAll();
		return userList;
	}
	
	
}
