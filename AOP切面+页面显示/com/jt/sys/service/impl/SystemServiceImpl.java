package com.jt.sys.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SystemService;
@Service
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Override
	public Map<String,Object> find() {
		SysUser user =(SysUser) SecurityUtils.getSubject().getPrincipal();
		List<Integer> roleIds=
				sysUserRoleDao.findRoleIdsByUserId(
						user.getId());
		//3.基于角色id查找菜单(资源)id
		Integer[] array={};
		List<Integer> menuIds=
				sysRoleMenuDao.findMenuIdsByRoleId(
						roleIds.toArray(array));
		//4.基于菜单id查找权限标识
		List<String> permisssions=
				sysMenuDao.findPermissions(
						menuIds.toArray(array));
		//5.封装权限信息(AuthorizationInfo)
		Set<String> pSet=
				new HashSet<String>();
		for(String permission:permisssions){
			if(!StringUtils.isEmpty(permission)){
				pSet.add(permission);
			}
		}
		Map<String,Object> map=new HashMap<>();
		if(pSet.contains("sys:config:view")) map.put("sys:config:view", "配置管理");
		if(pSet.contains("sys:log:view")) map.put("sys:log:view", "日志管理");
		if(pSet.contains("sys:user:view")) map.put("sys:user:view", "用户管理");
		if(pSet.contains("sys:menu:view")) map.put("sys:menu:view", "菜单管理");
		if(pSet.contains("sys:role:view")) map.put("sys:role:view", "角色管理");
		if(pSet.contains("sys:dept:view")) map.put("sys:dept:view", "组织管理");
 		/*List<String> list=new ArrayList<String>();
 		Iterator i=map.keySet().iterator();
 		while(i.hasNext()) {
 			String key=i.next().toString();
 			list.add((String) map.get(key));
 		}*/
		return map;
	}

}
