package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuDao {
	
	int updateObject(SysMenu entity);
	
	int insertObject(SysMenu entity);
	
	/**
	 * 查询菜单节点,此信息会在客户端
	 * 的zTree对象上进行呈现.
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 基于菜单id统计子菜单的个数
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);
	
	/**
	 * 基于菜单id执行删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 查询所有菜单以及上级菜单信息(菜单名) 
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	
	List<String> findPermissions(
			@Param("menuIds")
			Integer... menuIds);
}
