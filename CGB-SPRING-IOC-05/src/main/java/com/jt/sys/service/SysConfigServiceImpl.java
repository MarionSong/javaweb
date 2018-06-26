package com.jt.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;

@Service("sysConfigServiceImpl")
public class SysConfigServiceImpl implements SysConfigService{
	@Autowired
	private SysConfigDao sysConfigDao;
	@Override
	public SysConfig findById(Integer id) {
		if(id==null||id<1)
			throw new IllegalArgumentException("无效的参数");
		SysConfig sc = sysConfigDao.findById(id);
		if(sc==null)
			throw new RuntimeException("记录不存在");
		return sc;
	}

}
