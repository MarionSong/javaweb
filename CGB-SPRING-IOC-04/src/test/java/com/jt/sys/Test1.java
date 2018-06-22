package com.jt.sys;

import java.lang.annotation.Annotation;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jt.sys.controller.SysConfigController;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;



public class Test1 {
private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void testFindById01(){
		SqlSessionFactory factory=
		ctx.getBean(SqlSessionFactory.class);
		Assert.assertNotEquals(null, factory);
		//1.create session
		SqlSession session=factory.openSession();
		String statement=
		"com.jt.dao.SysConfigDao.findById";
		//2.execute query
		SysConfig sc=(SysConfig)
		session.selectOne(statement, 4);
		System.out.println(sc.getName());
		//3.close session
		session.close();
	}	
	
	@Test
	public void testFindById02() {
		SqlSessionFactory factory=
				ctx.getBean(SqlSessionFactory.class);
		SqlSession session=factory.openSession();
		SysConfigDao dao = session.getMapper(SysConfigDao.class);
		SysConfig sc=dao.findById(4);
		System.out.println(sc);
		session.close();
		
	}
	@Test
	public void testFindById03() {
		//直接获取dao对象，需要在配置文件中添加MapperScannerConfigurer
		SysConfigController dao = ctx.getBean("sysConfigController",SysConfigController.class);
		SysConfig sc=dao.findById(4);
		System.out.println(sc);
	
		
	}
	
	@After
	public void close() {
		ctx.close();

	}
	
	
	
	
}
