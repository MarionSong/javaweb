package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.EasyUITree;
import com.jt.manage.pojo.ItemCat;

public interface ItemCatService {
	public List<ItemCat> findAll(Integer page, Integer rows);

	public String findNameById(Long itemId);

	public List<EasyUITree> findItemCatByParentId(Long parentId);
}
