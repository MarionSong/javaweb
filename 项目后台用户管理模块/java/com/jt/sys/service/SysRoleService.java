package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;

public interface SysRoleService {
	
	int updateObject(SysRole entity,Integer[] menuIds);
	Map<String,Object> findObjectById(Integer id) ;
	int saveObject(SysRole entity,Integer[] menuIds);
	int deleteObject(Integer id);
	/**
     * 本方法中要分页查询角色信息,并查询角色总记录数据
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
	 PageObject<SysRole> findPageObjects(
			 String name,Integer pageCurrent);

	 List<CheckBox> findObjects(); 

	    
}
