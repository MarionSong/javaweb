package com.jt.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	
	@Override
	public int deleteObjects(Integer... ids) {
		//1.验证有效性
		if(ids==null||ids.length==0)
		throw new IllegalArgumentException("必须选中要删除的内容");
		//2.执行删除操作
		int rows=0;
		try{
		rows=sysConfigDao.deleteObjects(ids);
		}catch(Throwable e){
		e.printStackTrace();
		//给运维人员发短信
		throw new RuntimeException("系统修复中");
		}
		//3.判定结果并返回
		if(rows==0)
		throw new ServiceException("对应的记录已经不存在");
		return rows;
	}
	
	@Override
	public PageObject<SysConfig> findPageObjects(
		String name, Integer pageCurrent) {
		//1.参数的合法性校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数;
		int rowCount=sysConfigDao.getRowCount(name);
		//3.验证总记录数(假如总记录数为0,则抛出异常)
		if(rowCount==0)
	    throw new ServiceException("系统中没有找到对应数据");
		//4.查询当前页数据(配置信息)
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysConfig> pageRecords=
		sysConfigDao.findPageObjects(name,
				startIndex, pageSize);
		//5.封装数据并返回.
		PageObject<SysConfig> pageObject=
				new PageObject<SysConfig>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(pageRecords);
		return pageObject;
	}

}
