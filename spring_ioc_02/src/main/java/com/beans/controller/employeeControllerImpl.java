package com.beans.controller;

import com.beans.dao.employee;
import com.beans.pojo.Employee;
import com.beans.service.employeeService;

public class employeeControllerImpl {
	private employeeService employeeService;
	public void setEmployeeService(employeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee findById(Integer id) {
		if(id==null||id<1) {
			throw new IllegalArgumentException("id的值无效");
		}
		Employee findById = employeeService.findById(id);

		if(findById==null) {
			throw new RuntimeException("此记录不存在");
		}
		return findById;
	}
	
}
