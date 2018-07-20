package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	/*
	 * get			/item/cat/all?page=2&rows=10
	 * post			写在表单中<input type="hidden" name="page" value="2">
	 * RESTFul		/itemcat/all/2/10
	 */
	@RequestMapping("/all/{page}/{rows}")
	@ResponseBody	//返回值是一个Json字符串
	public List<ItemCat> findAll(@PathVariable Integer page,@PathVariable  Integer rows){
		List<ItemCat> itemCatList = itemCatService.findAll(page, rows);
		return itemCatList;
	}
}
