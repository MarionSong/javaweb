package com.jt.sys.service.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysUser;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserDao sysUserDao;
	/**
	 * 设置凭证匹配器
	 * @param credentialsMatcher
	 */
	@Override
	public void setCredentialsMatcher(
			CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher=
				new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		super.setCredentialsMatcher(cMatcher);
	}
	/**
	 * 执行认证操作时,此方法用户获取用户认证信息
	 * 说明:此方法由认证管理器调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token)throws AuthenticationException {
		//1.获取客户端提交的用户信息
		UsernamePasswordToken upToken=
				(UsernamePasswordToken)token;
		String username=upToken.getUsername();
		//2.基于用户名从数据库查询用户信息
		SysUser user=sysUserDao.findUserByUserName(username);
		System.out.println(user);
		//3.校验用户信息(用户存在吗)
		if(user==null)
			throw new AuthenticationException("用户不存在");
		if(user.getValid()==0)
			throw new AuthenticationException("此用户被禁用");
		//4.对用户信息进行封装
		ByteSource credentialsSalt=
				ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
						user, //principal(用户身份)
						user.getPassword(),//hashedCredentials(已经加密的密码)
						credentialsSalt, //credentialsSalt(盐)
						this.getName());//realm name
		return info;//此对象返回给谁了?认证管理器
	}
	/**执行授权操作时,此方法用于获取用户的权限信息*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//完成授权操作时需要在此方法完成数据获取与封装
		//。。。。。。。。
		//1.获取用户对象(此对应依赖与认证时封装的用户身份)
		SysUser user=(SysUser)
				principals.getPrimaryPrincipal();
		//2.基于用户id查找角色Id
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
		}//去重和空(null),空串
		System.out.println("pSet="+pSet);
		SimpleAuthorizationInfo info=                                                        
				new SimpleAuthorizationInfo();
		info.setStringPermissions(pSet);
		return info;
	}
}
