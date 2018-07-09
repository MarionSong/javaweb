package com.jt.sys.service;

import java.util.Map;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.SysUserDeptResult;
import com.jt.sys.entity.SysUser;

public interface SysUserService {
	PageObject<SysUserDeptResult> findPageObjects(
			String username,
			Integer pageCurrent);
	
	
	int validById(Integer id,Integer valid,String modifiedUser);
	int saveObject(SysUser entity,Integer[] roleIds);
	Map<String,Object> findObjectById(Integer userId);
	int updateObject(SysUser entity,Integer[] roleIds);
}
