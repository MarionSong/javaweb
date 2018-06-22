package test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import beans.OpenDataSource;
import beans.controller.SysConfigController;
import beans.dao.SysConfigDao;
import beans.dao.impl.SysConfigDaoImpl;
import beans.service.SysConfigService;

public class TestDataSource02 {
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void testSystConfigDao() {
		SysConfigDao bean = ctx.getBean("sysConfigDao",SysConfigDao.class);
		bean.findById(4);
		System.out.println(bean);
	}
	
	@Test
	public void testSysConfigService() {
		SysConfigService bean = ctx.getBean("sysConfigService",SysConfigService.class);
		bean.findById(4);
		System.out.println(bean);
	}
	@Test
	public void testSysConfigController() {
		SysConfigController bean = ctx.getBean("sysConfigController",SysConfigController.class);
		bean.doFindById(4);
		System.out.println(bean);
	}
	@After
	public void close() {
		ctx.close();

	}
	
}	
