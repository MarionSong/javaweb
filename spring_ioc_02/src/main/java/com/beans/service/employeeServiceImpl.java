package com.beans.service;

import com.beans.dao.employee;
import com.beans.pojo.Employee;

public class employeeServiceImpl implements employeeService{
	private employee employee;
	public void setEmployee(employee employee) {
		this.employee = employee;
	}
	@Override
	public Employee findById(Integer id) {
		
		if(id==null||id<1) {
			throw new IllegalArgumentException("id的值无效");
		}
		Employee findById = employee.findById(id);

		if(findById==null) {
			throw new RuntimeException("此记录不存在");
		}
		return findById;
	}
	
}
