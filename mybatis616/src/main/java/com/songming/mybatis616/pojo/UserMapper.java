package com.songming.mybatis616.pojo;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public User find(User user);
	public void insert(User user);
}
