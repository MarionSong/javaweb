package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;

public interface ItemService {
	public EasyUIResult findItemByPage(Integer page,Integer rows);

	public void saveItem(Item item);

	public void updateItem(Item item);

	public void deleteItem(Long[] ids);

	public void updateStatus(int status, Long[] ids);
}
