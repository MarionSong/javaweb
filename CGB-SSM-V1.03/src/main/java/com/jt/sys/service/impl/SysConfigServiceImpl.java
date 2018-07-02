package com.jt.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	@Override
	public List<SysConfig> findPageObjects(
			String name, 
			Integer pageCurrent) {
		//1.参数合法性验证
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码值无效");
		//2.查询当前页数据
		Integer pageSize=2;
		Integer startIndex=(pageCurrent-1)*2;
		List<SysConfig> records=
		sysConfigDao.findPageObjects(name,
				startIndex, pageSize);
		//3.返回数据
		return records;
	}
}





