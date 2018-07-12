package com.jt.sys.service.impl;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.anno.RequestLog;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	@RequiresPermissions("sys:config:update")
	@RequestLog("更新数据")
	//Controller-->访问
	//RPC-->访问
	@Override
	public int updateObject(SysConfig entity) {
		//1.合法校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("参数名不能为空");
		if(StringUtils.isEmpty(entity.getValue()))
			throw new IllegalArgumentException("参数值不能为空");
		//2.保存数据
		int rows=0;
		try{
			rows=sysConfigDao.updateObject(entity);
		}catch(Throwable e){
			e.printStackTrace();
			//给运维人员发短信.
			throw new ServiceException("系统故障,正在修复中");
		}
		//3.返回更新的行数
		return rows;
	}
	//Controller-->访问
	//RPC-->访问
	@Override
	@RequestLog("保存对象")
	@RequiresPermissions("sys:config:add")
	public int saveObject(SysConfig entity) {
		//1.合法校验
		if(entity==null)
		throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new IllegalArgumentException("参数名不能为空");
		if(StringUtils.isEmpty(entity.getValue()))
		throw new IllegalArgumentException("参数值不能为空");
		//2.保存数据
		int rows=0;
		try{
		rows=sysConfigDao.insertObject(entity);
		}catch(Throwable e){
		e.printStackTrace();
		//给运维人员发短信.
		throw new ServiceException("系统故障,正在修复中");
		}
		//3.返回更新的行数
		return rows;
	}
	@RequiresPermissions("sys:config:delete")
	@RequestLog("删除数据")
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
	@RequiresPermissions("sys:config:view")
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
