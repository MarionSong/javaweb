package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.service.SysMenuService;
import com.sun.javafx.collections.MappingChange.Map;
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuDao.findObjects() ;
	}
	@Override
	public int deleteObject(Integer id) {
		if(id==null||id<1)
			throw new ServiceException("请先选择");
		int count=sysMenuDao.getChildCount(id);
		if(count>0)
			throw new ServiceException("请先删除子菜单");
		int row = sysMenuDao.deleteObject(id);
		if(row==0)
			throw new ServiceException("记录可能已经被删除");
		sysRoleMenuDao.deleteObjectByMenuId(id);
		
		return row;
	}

}
