package com.jt.sys.service;

import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;

public class SysConfigServiceImpl implements SysConfigService{
	private SysConfigDao sysConfigDao;
	public void setSysConfigDao(SysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}
	public SysConfig findById(Integer id) {
		if(id==null||id<1) {
			throw new IllegalArgumentException("id的值无效");
		}
		SysConfig sc=sysConfigDao.findById(id);

		if(sc==null) {
			throw new RuntimeException("此记录不存在");
		}
		return sc;
	}

}
