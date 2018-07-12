package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {
	/**
	 * 基于角色查询菜单id
	 * @param roleId
	 * @return
	 */
	List<Integer> findMenuIdsByRoleId(
			@Param("roleIds")Integer... roleIds);
	
	 /**
	  * 插入角色和菜单的关系数据
	  * @param roleId
	  * @param menuIds
	  * @return
	  */
	 int insertObject(
			 @Param("roleId") Integer roleId,
			 @Param("menuIds")Integer[] menuIds);
	
	 /**
	  * 基于菜单id删除角色和菜单关系表中的数据
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
