package com.jt.manage.mapper;


import java.util.List;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.User;
//必须实现SysMapper接口，泛型接口，加上泛型
public interface UserMapper extends SysMapper<User>{
	public List<User> findAll();
}
