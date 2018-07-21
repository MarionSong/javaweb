package com.jt.manage.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;
@RequestMapping("/item")
@Controller
public class ItemController {
	private static final Logger logger=Logger.getLogger(ItemController.class);
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItem(Integer page,Integer rows){
		return itemService.findItemByPage(page,rows);
	}
	@ResponseBody
	@RequestMapping("/save")
	public SysResult saveItem(Item item) {
		try {
			itemService.saveItem(item);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品新增失败");
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item) {
		try {
			itemService.updateItem(item);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品更新失败");
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	//自动根据逗号拆成字符串
	public SysResult deleteItem(Long[] ids) {
		try {
			
			itemService.deleteItem(ids);
			logger.info("{我是帅哥}");
			return SysResult.oK();
		} catch (Exception e) {
			logger.error("~~~~~~~"+e.getMessage());
			
		}
		return SysResult.build(201, "商品删除失败");
	}
	
	
	@RequestMapping("/reshelf")
	@ResponseBody
	public SysResult reshelf(Long[] ids) {
		try {
			int status=1;
			itemService.updateStatus(status,ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品上架失败");
		
	}
	
	@RequestMapping("/instock")
	@ResponseBody
	public SysResult instock(Long[] ids) {
		try {
			int status=2;
			itemService.updateStatus(status,ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品下架失败");
		
		
	}
	
	
	
	
}
