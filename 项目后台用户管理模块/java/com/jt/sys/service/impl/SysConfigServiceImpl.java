package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Service
public class SysConfigServiceImpl implements SysConfigService{
     @Autowired
	 private SysConfigDao sysConfigDao;
     
     @Override
 	public int updateObject(SysConfig entity) {
    	 //1.合法性验证
		  if(entity==null)
		  throw new IllegalArgumentException("对象不能为空");
		  if(StringUtils.isEmpty(entity.getName()))
		  throw new IllegalArgumentException("参数名不能为空");
		  if(StringUtils.isEmpty(entity.getValue()))
		  throw new IllegalArgumentException("参数值不能为空");
		//2.将数据写入到数据库
	 		int rows;
	 		try{
	 		rows=sysConfigDao.updateObject(entity);
	 		}catch(Throwable t){
	 		t.printStackTrace();
	 		//报警....
	 		throw new ServiceException("系统故障，正在恢复");
	 		}
	 		//3.返回结果
	 		return rows;
 	}
 	
     @Override
 	public int saveObject(SysConfig entity) {
    	//1.合法验证
 		if(entity==null)
 		throw new IllegalArgumentException("保存对象不能为空");
 		if(StringUtils.isEmpty(entity.getName()))
 		throw new IllegalArgumentException("参数名不能为空");
 		if(StringUtils.isEmpty(entity.getValue()))
 		throw new IllegalArgumentException("参数值不能为空");
 		//2.将数据写入到数据库
 		int rows;
 		try{
 		rows=sysConfigDao.insertObject(entity);
 		}catch(Throwable t){
 		t.printStackTrace();
 		//报警....
 		throw new ServiceException("系统故障，正在恢复");
 		}
 		//3.返回结果
 		return rows;
 	}
     
     
     @Override
 	public int deleteObjects(Integer... ids) {
    	//1.判定参数合法性
 		if(ids==null||ids.length==0)
 	    throw new IllegalArgumentException("请选择一个");
 		//2.执行删除操作
 		int rows;
 		try{
 		rows=sysConfigDao.deleteObjects(ids);
 		}catch(Throwable e){
 		e.printStackTrace();
 		//发出报警信息(例如给运维人员发短信)
 		throw new ServiceException("系统故障，正在恢复中...");
 		}
 		//4.对结果进行验证
 		if(rows==0)
 		throw new ServiceException("记录可能已经不存在");
 		//5.返回结果
 		return rows;
 	}
	@Override
	public PageObject<SysConfig> findPageObjects(String name, Integer pageCurrent) {
		//1.验证参数合法性
		  //1.1验证pageCurrent的合法性，
		  //不合法抛出IllegalArgumentException异常
		  if(pageCurrent==null||pageCurrent<1)
		  throw new IllegalArgumentException("当前页码不正确");
		  //2.基于条件查询总记录数
		  //2.1) 执行查询
		  int rowCount=sysConfigDao.getRowCount(name);
		  //2.2) 验证查询结果，假如结果为0不再执行如下操作
		  if(rowCount==0)
		  throw new ServiceException("系统中没有找到记录");
		  //3.基于条件查询当前页记录(pageSize定义为2)
		  //3.1)定义pageSize
		  int pageSize=2;
		  //3.2)计算startIndex
		  int startIndex=(pageCurrent-1)*pageSize;
		  //3.3)执行当前数据的查询操作
		  List<SysConfig> records=
		  sysConfigDao.findPageObjects(name, startIndex, pageSize);
		  //4.对分页信息以及当前页记录进行封装
		  //4.1)构建PageObject对象
		  PageObject<SysConfig> pageObject=
				  new PageObject<>();
		  //4.2)封装数据
		  pageObject.setPageCurrent(pageCurrent);
		  pageObject.setPageSize(pageSize);
		  pageObject.setRowCount(rowCount);
		  pageObject.setRecords(records);
		  //5.返回封装结果。
		  return pageObject;
	}


	


	
}
