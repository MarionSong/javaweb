package com.jt.sys.service;

import java.util.List;

import com.jt.sys.entity.SysConfig;

public interface SysConfigService {
	/**
	 * @param name
	 * @param pageCurrent 当前页码
	 * @return
	 */
	List<SysConfig> findPageObjects(
			String name,
			Integer pageCurrent);
}




