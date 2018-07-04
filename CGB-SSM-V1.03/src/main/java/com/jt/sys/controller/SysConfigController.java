package com.jt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Controller
@RequestMapping("/config/")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;
    @RequestMapping("doFindPageObjects")
    @ResponseBody
	public List<SysConfig> doFindPageObjects(
			String name,Integer pageCurrent){
		return sysConfigService.findPageObjects(
				 name,pageCurrent);
	}
    @RequestMapping("doFindPageRecords")
    @ResponseBody
	public ModelAndView doFindPageRecords(
			String name,Integer pageCurrent){
    	List<SysConfig> list=sysConfigService.findPageObjects(
				 name,pageCurrent);
    	ModelAndView mv = new ModelAndView("config");
    	mv.addObject("records", list);
    	return mv;

	}
}
