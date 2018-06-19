package com.songming.mybatis616.pojo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public User find(User user);
	public void insert(User user);
	public List<User> testfind();
}
