package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

//中间表的dao
public interface SysRoleMenuDao {
	List<Integer> findMenuIdsByRoleId(Integer roleId);
	int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	/**
	 * 基于菜单id删除角色和菜单关系表中的联系
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
	
	/**
	 * 基于角色id删除角色菜单关系中的记录
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
}
