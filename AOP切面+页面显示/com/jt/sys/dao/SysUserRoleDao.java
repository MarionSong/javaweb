package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {
	
	  /**
	   * 基于用户id删除用户角色关系数据
	   * @param userId
	   * @return
	   */
	  int deleteObjectsByUserId(Integer userId);
	
	  /**
	   * 根据用户id查询用户所拥有的角色信息
	   * @param userId
	   * @return
	   */
	  List<Integer> findRoleIdsByUserId(Integer userId);
	
      /**
       * 基于角色id删除用户与角色关系表中的数据
       * @param roleId
       * @return
       */
	  int deleteObjectsByRoleId(
			  Integer roleId);
	  
	  
	  
	  int insertObject(
				 @Param("userId")Integer userId,
				 @Param("roleIds")Integer[] roleIds);
}
