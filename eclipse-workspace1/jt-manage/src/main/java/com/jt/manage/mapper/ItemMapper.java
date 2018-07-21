package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Item;

public interface ItemMapper extends SysMapper<Item>{
	/**
	 * mybatis 不允许多值传参，必须将多值封装为单值
	 * 封装为对象
	 * 封装为Map @Param
	 * 封装为array或者list
	 * $只有以字段名称为参数时才使用，除此之前都用#因为有预编译效果，防止注入攻击
	 * @param start
	 * @param rows
	 * @return
	 */
	
	
	@Select("select * from tb_item order by updated desc limit #{start},#{rows}")
	List<Item> findItemByPage(@Param("start")int start,@Param("rows")int rows);
	
	
	void updateStatus(@Param("status")int status, @Param("ids")Long[] ids);
}
