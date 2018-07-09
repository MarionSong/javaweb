package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.SysUserDeptResult;
import com.jt.sys.entity.SysUser;

public interface SysUserDao {
	List<SysUserDeptResult> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

	int getRowCount(@Param("username") String username);

	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	int insertObject(SysUser entity);
	SysUser findObjectById(Integer userId);
	int updateObject(SysUser entity);
}
