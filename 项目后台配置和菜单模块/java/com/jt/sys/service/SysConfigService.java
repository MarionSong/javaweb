package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;

public interface SysConfigService {
	
	 PageObject<SysConfig> findPageObjects(
			 String name,
			 Integer pageCurrent);
	 int deleteObjects(Integer ...ids) ;
	 int saveObject(SysConfig entity);
	 int updateObject(SysConfig entity);
}
