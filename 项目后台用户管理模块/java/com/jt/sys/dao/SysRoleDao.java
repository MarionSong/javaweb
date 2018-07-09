package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.vo.CheckBox;
import com.jt.sys.entity.SysRole;

public interface SysRoleDao {
	SysRole findObjectById(Integer id);
	/**
	 * 基于角色id删除角色自身信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	 /**
     * 分页查询角色信息
     * @param startIndex 上一页的结束位置
     * @param pageSize 每页要查询的记录数
     * @return
     */
	List<SysRole> findPageObjects(
             @Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 查询记录总数
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	//当参数应用在了动态sql中时，这个参数最好使用@Param注解修饰
	int insertObject(SysRole entity);
	int updateObject(SysRole entity);
	List<CheckBox> findObjects();
}
