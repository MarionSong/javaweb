package com.jt.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigDao {
	/**
	 * @param name 查询时的配置信息的名字
	 * @param startIndex 查询当前页的起始位置
	 * @param pageSize  每页最多显示多少行记录
	 * @return
	 */
	List<SysConfig> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}
