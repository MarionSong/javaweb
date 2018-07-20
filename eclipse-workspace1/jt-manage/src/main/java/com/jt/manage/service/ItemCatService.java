package com.jt.manage.service;

import java.util.List;

import com.jt.manage.pojo.ItemCat;

public interface ItemCatService {
	public List<ItemCat> findAll(Integer page, Integer rows);
}
