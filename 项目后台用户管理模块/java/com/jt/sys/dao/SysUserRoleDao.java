package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysRole;

public interface SysUserRoleDao {
	/**
	 * 基于角色id删除用户与角色关系表中的数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);

	int insertObject(SysRole entity);
	/**
	 * 负责将用户与角色的关系数据写入到数据库
	 * @param userId 用户id
	 * @param roleIds 多个角色id
	 * @return
	 */
	int insertObject(
			@Param("userId")Integer userId,
			@Param("roleIds")Integer[] roleIds);

	List<Integer> findRoleIdsByUserId(
			Integer userId);
	
	int deleteObjects(Integer userId);
}
