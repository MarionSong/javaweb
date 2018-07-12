package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

public interface SysMenuService {
	
	 int updateObject(SysMenu entity);
	
	 int saveObject(SysMenu entity);
	
	
	 List<Node> findZtreeMenuNodes();
	
	 int deleteObject(Integer id);
  
	 List<Map<String,Object>> findObjects();
}
