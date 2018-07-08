package com.jt.sys.dao;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public interface SysMenuDao {
	
	List<Map<String,Object>> findObjects();
	int getChildCount(Integer id);
	int deleteObject(Integer id);
}
