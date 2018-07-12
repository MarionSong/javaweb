package com.jt.sys.service.impl;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	@RequiresPermissions("sys:log")
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        //1.验证参数合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new ServiceException("参数不合法");
		//2.查询总记录数
		int rowCount=sysLogDao.getRowCount(username);
		if(rowCount==0)
		throw new ServiceException("没有记录");
	    //2.查询当前页记录
		//2.1定义页面大小(每页最多现实多少条记录)
		int pageSize=3;
		//2.2计算当前页位置
		int startIndex=(pageCurrent-1)*pageSize;
		//2.3查询当前数据
		List<SysLog> list=sysLogDao.findPageObjects(
				username, 
				startIndex,
				pageSize);
		//3.封装数据
		PageObject<SysLog> pageObject=new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}

}
