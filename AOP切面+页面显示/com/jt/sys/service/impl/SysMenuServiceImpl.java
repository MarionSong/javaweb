package com.jt.sys.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.vo.Node;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
    private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@RequiresPermissions("sys:menu:update")
	@Override
	public int updateObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("参数不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("名字不能空");
		int rows=sysMenuDao.updateObject(entity);
		return rows;
	}
	@RequiresPermissions("sys:menu:add")
	@Override
	public int saveObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("参数不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("名字不能空");
		int rows=sysMenuDao.insertObject(entity);
		return rows;
	}
	
	
	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}
	@RequiresPermissions("sys:menu:delete")
	@Override
	public int deleteObject(Integer id) {
		//1.校验
		if(id==null||id<1)
		throw new IllegalArgumentException("id 的值不正确");
		//2.判定是否有子元素
		int count=sysMenuDao.getChildCount(id);
		if(count>0)
		throw new ServiceException("请先删除子元素");
		//3.删除菜单元素
		int rows=sysMenuDao.deleteObject(id);
		//4.删除角色菜单的关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}
	@RequiresPermissions("sys:menu:view")
	@Override
	public List<Map<String, Object>> 
	         findObjects() {
		return sysMenuDao.findObjects();
	}

}
