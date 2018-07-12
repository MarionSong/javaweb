package com.jt.sys.service;
import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserService {
	
	  int updateObject(SysUser entity,Integer[] roleIds);
	 
	  /**
	   * 基于用户id查找用户信息,部门信息以及角色信息
	   * @param id 用户id
	   * @return
	   */
	  Map<String,Object> findObjectById(Integer id);
	  
	
	  int saveObject(
			  SysUser entity,
			  Integer[] roleIds);
	  /**
	   * 禁用或启用状态信息
	   * @param id
	   * @param valid
	   * @return
	   */
	  int validById(Integer id,Integer valid,String modifiedUser);
      /**
       * 基于条件执行分页查询操作
       * @param name
       * @param pageCurrent
       * @return
       */
	  PageObject<SysUserDeptResult>
	  findPageObjects(String username,
			  Integer pageCurrent);
}




