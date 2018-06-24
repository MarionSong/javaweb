package com.beans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.beans.controller.employeeControllerImpl;
import com.beans.dao.employee;
import com.beans.dao.impl.employeeImpl;
import com.beans.pojo.Employee;
import com.beans.service.employeeService;

public class Test1 {
	private ClassPathXmlApplicationContext ctx;

	@Before
	public void init() {
			ctx=new ClassPathXmlApplicationContext("spring-configs.xml");	
	}
	
	@Test
	public void testDataSource() {
		employee bean = ctx.getBean("employee",com.beans.dao.employee.class);
		Employee id = bean.findById(1);
		System.out.println(id);
	}
	
	@Test
	public void testService() {
		employeeService bean = ctx.getBean("employeeService",com.beans.service.employeeService.class);
		Employee findById = bean.findById(2);
		System.out.println(findById);
	}
	
	@Test
	public void testController() {
		employeeControllerImpl bean = ctx.getBean("employeeController",employeeControllerImpl.class);
		Employee findById = bean.findById(2);
		System.out.println(findById);
	}
	
	
	@After
	public void close() {
		ctx.close();

	}
}
