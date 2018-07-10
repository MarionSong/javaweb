package com.jt.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserDao {
	
	/**
	 * 更新用户信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	
	/**
	 * 根据用户id查询用户以及对应的部门信息
	 * @param id (用户id)
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	
	
    int getUserCountByDeptId(Integer deptId);
	
	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	 SysUser findUserByUserName(String username);
	
	 int insertObject(SysUser entity);
	
	 /**
	  * 赋值执行禁用和启用操作
	  * @param id 要禁用或启用的记录id
	  * @param valid 禁用或启用的标识
	  * @return
	  */
	 int validById(@Param("id")Integer id,
			       @Param("valid")Integer valid,
			       @Param("modifiedUser") String modifiedUser);
	
	 List<SysUserDeptResult> findPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 
	 int getRowCount(@Param("username")String username);

}
