package com.jt.sys.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@RequiresPermissions("sys:role:view")  
	 @Override
	  public List<CheckBox> findObjects() {
	    	return sysRoleDao.findObjects();
	    }
	 
	@Override
	public Map<String, Object> findObjectById(
			Integer id) {
		//1.校验
		if(id==null||id<1)
		throw new IllegalArgumentException("id的值无效");
		//2.查询
		SysRole sysRole=sysRoleDao.findObjectById(id);
		if(sysRole==null)
	    throw new ServiceException("此记录已经不存在");
		List<Integer> menuIds=
		sysRoleMenuDao.findMenuIdsByRoleId(id);
		//3.封装
		Map<String,Object> map=new HashMap<>();
		map.put("role", sysRole);
		map.put("menuIds", menuIds);
		//4.返回
		return map;
	}
	
	/**
	 * 保存角色以及角色和菜单关系数据
	 */
	@RequiresPermissions("sys:role:add")
	@Override
	public int saveObject(SysRole entity, 
			Integer[] menuIds) {
		//1.校验
		if(entity==null)
		throw new IllegalArgumentException("角色信息不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new IllegalArgumentException("角色不能为空");
		if(menuIds==null||menuIds.length==0)
	    throw new IllegalArgumentException("必须为角色分配一个资源");
		//2.保存
		int rows=sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObject(
				entity.getId(),
				menuIds);
		return rows;
	}
	@RequiresPermissions("sys:role:update")
	@Override
	public int updateObject(SysRole entity, 
			Integer[] menuIds) {
		//1.校验
		if(entity==null)
			throw new IllegalArgumentException("角色信息不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new IllegalArgumentException("必须为角色分配一个资源");
		//2.保存
		int rows=sysRoleDao.updateObject(entity);
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObject(
				entity.getId(),
				menuIds);
		return rows;
	}
	@RequiresPermissions("sys:role:delete")
	@Override
	public int deleteObject(Integer id) {
		//1.校验
		if(id==null||id<1)
		throw new IllegalArgumentException("参数值不正确");
		//2.删除
		int rows=sysRoleDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//3.返回
		return rows;
	}
	@RequiresPermissions("sys:role:view")
	@Override
	public PageObject<SysRole> 
	        findPageObjects(String name,
			        Integer pageCurrent) {
		//1.参数有效性验证
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("参数值无效");
		//2.基于条件查询总记录数
		int rowCount=sysRoleDao.getRowCount(name);
		//3.判定总记录数
		if(rowCount==0)
		throw new ServiceException("记录不存在");
		//4.查询当前页数据
		Integer pageSize=2;
		Integer startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
		sysRoleDao.findPageObjects(name,
				startIndex, pageSize);
		//5.封装结果
		PageObject<SysRole> pageObject=new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		
		return pageObject;//pageCount=?
	}

}



