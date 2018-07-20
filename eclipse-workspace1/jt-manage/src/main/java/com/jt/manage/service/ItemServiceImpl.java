package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.service.BaseService;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class ItemServiceImpl extends BaseService<Item> implements ItemService{
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public EasyUIResult findItemByPage(Integer page,Integer rows) {
		
		int total=itemMapper.selectCount(null);
		int start=(page-1)*rows;
		List<Item> itemList= itemMapper.findItemByPage(start,rows);
		EasyUIResult result=new EasyUIResult(total,itemList);
		
		return result;
	}
	
	
	
}
