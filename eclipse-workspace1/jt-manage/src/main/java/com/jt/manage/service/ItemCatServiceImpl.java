package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.service.BaseService;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;

@Service
public class ItemCatServiceImpl extends BaseService<ItemCat> implements ItemCatService{
	//关联ItemCatMapper
	@Autowired
	private ItemCatMapper itemCatMapper;
	
	public List<ItemCat> findAll(Integer page, Integer rows){
		//return itemCatMapper.findAll();
		//分页支持，startPage方法是静态
		//内部就调用拦截器，startPage相当于事务开启begin，开启分页操作
		//它下面第一条的执行的查询的SQL语句
		PageHelper.startPage(page, rows); 	
		//第一条查询SQL被拦截，SQL语句拼接 limit page, rows
		List<ItemCat> itemCatList = itemCatMapper.findAll();
		
		//返回值不能直接返回，必须放在PageInfo对象中
		//这里和线程安全有关！直接返回方式它会产生线程安全问题
		//怎么解决？利用ThreadLocal，把当前对象和当前线程绑定，每个用户独立线程，
		PageInfo<ItemCat> pageInfo = new PageInfo<ItemCat>(itemCatList);
		
		return pageInfo.getList();
		
	}
}
