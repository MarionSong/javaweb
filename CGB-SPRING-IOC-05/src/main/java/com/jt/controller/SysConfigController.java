package com.jt.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
//表示控制层Bean

import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Controller("sysConfigController")
public class SysConfigController {
	/*@Autowired 
	@Qualifier("sysConfigServiceImpl")*/
	//@Resource//按属性名去查找，找不到找类型
	@Autowired
	private SysConfigService sysConfigService;
	//按照set方法中的参数类型属性注入值
	/*@Autowired
	public void setSysCOnfigService(SysConfigService sysCOnfigService) {
		this.sysConfigService = sysCOnfigService;
	}*/
	public SysConfig findById(Integer id) {
		if(id==null||id<1)
			throw new IllegalArgumentException("无效的参数");
		SysConfig sc = sysConfigService.findById(id);
		if(sc==null)
			throw new RuntimeException("记录不存在");
		return sc;
	}
}
