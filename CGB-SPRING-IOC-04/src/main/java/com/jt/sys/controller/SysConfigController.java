package com.jt.sys.controller;

import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

public class SysConfigController {
	private SysConfigService sysConfigService;
	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}
	
	public SysConfig findById(Integer id) {
		if(id==null||id<1) {
			throw new IllegalArgumentException("id的值无效");
		}
		SysConfig sc=sysConfigService.findById(id);
		if(sc==null) {
			throw new RuntimeException("此记录不存在");
		}
		return sc;
	}
	
	
}
