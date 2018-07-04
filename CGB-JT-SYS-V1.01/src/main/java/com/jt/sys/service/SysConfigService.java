package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;

public interface SysConfigService {
	
	int deleteObjects(Integer... ids);
	
	/**
	 * 查询当前页数据
	 * 查询总记录数
	 * @param name 查询时的参数名
	 * @param pageCurrent 当前页的页码
	 * @return
	 */
	PageObject<SysConfig> findPageObjects(
		String name,Integer pageCurrent);
}
