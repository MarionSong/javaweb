package com.jt.sys.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.vo.PageObject;
import com.jt.common.vo.ServiceException;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
	private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    
    @RequiresPermissions("sys:user:delete")
    @Override
    public int updateObject(SysUser entity, Integer[] roleIds) {
    	//1.校验
    	if(entity==null)
    	throw new IllegalArgumentException("更新对象不能为空");
    	if(StringUtils.isEmpty(entity.getUsername()))
    	throw new IllegalArgumentException("用户名不能为空");
    	if(roleIds==null||roleIds.length==0)
    	throw new IllegalArgumentException("需要为用户分配角色");
    	if(!StringUtils.isEmpty(entity.getPassword())){
    		String salt=UUID.randomUUID().toString();
    		entity.setSalt(salt);
    		SimpleHash sh=
    		new SimpleHash("MD5",entity.getPassword(),salt);
    		entity.setPassword(sh.toString());
    	}
    	//2.更新
    	int rows=sysUserDao.updateObject(entity);
    	sysUserRoleDao.deleteObjectsByUserId(entity.getId());
    	sysUserRoleDao.insertObject(entity.getId(), roleIds);
    	//3.返回
    	return rows;
    }
    
    @Override
    public Map<String, Object> 
        findObjectById(Integer id) {
    	//1.参数有效性验证
    	if(id==null||id<1)
    	throw new IllegalArgumentException("id的值无效");
    	//2.查询用户以及部门信息
    	SysUserDeptResult user=
    	sysUserDao.findObjectById(id);
    	if(user==null)
    	throw new ServiceException("此用户可能已经不存在");
    	//3.查询用户对应的角色信息
    	List<Integer> roleIds=
    	sysUserRoleDao.findRoleIdsByUserId(id);
    	//4.封装数据并返回.
    	Map<String,Object> map=new HashMap<>();
    	map.put("user", user);
    	map.put("roleIds", roleIds);
    	return map;
    }
    
    @RequiresPermissions("sys:user:add")
    @Override
    public int saveObject(SysUser entity,
    		Integer[] roleIds) {
    	//1.参数合法验证
    	if(entity==null)
    	throw new IllegalArgumentException("保存对应不能为空");
    	//...验证名字是否为空,是否唯一,...
    	//...验证密码是否为空,是不是数字和字母的组合,长度,,
    	if(roleIds==null||roleIds.length==0)
    	throw new IllegalArgumentException("必须为用户分配角色");
    	//2.保存数据
    	//2.1 创建一个盐值(用于辅助加密,保证密码更加安全的一种手段)
    	String salt=UUID.randomUUID().toString();
    	String pwd=entity.getPassword();
    	//2.3 对密码进行加密,加密算法md5
    	SimpleHash sh=//这个api属于shiro框架,后续需要引入shiro依赖
    	new SimpleHash("MD5",//algorithmName 表示加密算法
    			pwd, //source 为要加密的对象
    			salt);//salt 加密盐值
    	entity.setPassword(sh.toHex());
    	entity.setSalt(salt);
    	//2.4设置对象其它属性默认值
    	entity.setCreatedTime(new Date());
    	entity.setModifiedTime(new Date());
    	//2.5保存用户自身信息
    	int rows=sysUserDao.insertObject(entity);
    	//2.6保存用户与角色的关系数据
    	sysUserRoleDao.insertObject(entity.getId(),
    			roleIds);
    	//3.返回结果
    	return rows;
    }
    /**
     * 在需要进行授权检测的方法上添加执行此方法需要的权限标识
     * 当底层系统运行时，检测到此方法使用了@RequiresPermissions
     * 就会为业务对象创建一个代理对象，然后在代理对象中subject.isPermitted("sys:user:valid")
     * 方法进行权限检测
     */
    @RequiresPermissions("sys:user:valid")
    @Override
    public int validById(Integer id,
    		Integer valid,
    		String modifiedUser) {
    	if(id==null||id<1)
    	throw new IllegalArgumentException("id值无效");
    	if(valid==null||(valid!=1&&valid!=0))
    	throw new IllegalArgumentException("状态值无效");
    	int rows=sysUserDao.validById(id,valid,modifiedUser);
    	if(rows==0)
    	throw new ServiceException("记录可能已经不存在");
    	return rows;
    }
    @RequiresPermissions("sys:user:view")
	@Override
	public PageObject<SysUserDeptResult> 
	findPageObjects(String username, 
			Integer pageCurrent) {
		//1.合法验证
	    if(pageCurrent==null||pageCurrent<1)
	    throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数
	    int rowCount=sysUserDao.getRowCount(username);
		//3.对记录数进行验证
	    if(rowCount==0)
	    throw new ServiceException("没有记录");
		//4.查询当前页数据
	    int pageSize=5;
	    int startIndex=(pageCurrent-1)*pageSize;
	    List<SysUserDeptResult> records=
	    sysUserDao.findPageObjects(username,
	    		startIndex, pageSize);
		//5.对数据进行封装
	    PageObject<SysUserDeptResult> po=new PageObject<>();
	    po.setRowCount(rowCount);
	    po.setRecords(records);
	    po.setPageSize(pageSize);
	    po.setPageCurrent(pageCurrent);
		//6.返回结果
		return po;
	}

}





