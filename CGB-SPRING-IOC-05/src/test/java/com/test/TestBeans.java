package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.common.config.AppConfig;
import com.jt.common.util.OpenDataSource;
import com.jt.controller.SysConfigController;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;

public class TestBeans {
	AnnotationConfigApplicationContext context ;
	@Before
	public void init() {
		//构建context对象
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
	}
	@Test
	public void test() {
		//获取bean对象并输出
		SysConfigController bean = context.getBean("sysConfigController",SysConfigController.class);
		SysConfig findById = bean.findById(4);
		System.out.println(findById);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		//获取bean对象并输出
		DataSource bean = context.getBean("dataSource",DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void testFactory() {
		SqlSessionFactory ssf=context.getBean(SqlSessionFactory.class);
		System.out.println(ssf);
		
	}
	
	@Test
	public void testSysConfig() {
		SysConfigDao bean = context.getBean("sysConfigDao",SysConfigDao.class);
		SysConfig findById = bean.findById(4);
		System.out.println(findById);
	}
		
	@After	
	public void close() {	
		//关闭时才会执行destory
		context.close();
		
	}
	
}
