package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;

public interface SysRoleService {
	
	 /***
	   * 查询所有的系统角色信息
	   * @return
	   */
	  List<CheckBox> findObjects();
	
	 /**
	  * 基于角色id查询对应的菜单
	  * @param id
	  * @return
	  */
	 Map<String,Object> findObjectById(
			 Integer id) ;
	
	
	 int updateObject(
			 SysRole entity,
			 Integer[] menuIds);
	 
	 int saveObject(
			 SysRole entity,
			 Integer[] menuIds);
	 
	
	 int deleteObject(Integer id);

	 PageObject<SysRole> findPageObjects(
			 String name,
			 Integer pageCurrent);
}
