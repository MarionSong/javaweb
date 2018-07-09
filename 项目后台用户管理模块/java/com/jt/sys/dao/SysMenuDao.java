package com.jt.sys.dao;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuDao {
	
	int updateObject(SysMenu entity);
	
	int insertObject(SysMenu entity);
	/**
	 * 查询菜单节点，此信息会在客户端的zTree对象上进行呈现
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	  * 根据菜单id统计子菜单的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	
	 /**
	  * 根据菜单id 删除菜单
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 
	/**
	 * 查询所有菜单以及上级菜单信息(菜单名)
	 * @return
	 */
	List<Map<String,Object>> findObjects();
}
