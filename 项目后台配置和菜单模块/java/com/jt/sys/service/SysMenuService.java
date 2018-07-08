package com.jt.sys.service;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	int deleteObject(Integer id);
}
