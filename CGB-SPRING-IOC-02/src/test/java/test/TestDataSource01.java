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

public class TestDataSource01 {
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void openDataSource1() {
		OpenDataSource bean = ctx.getBean("openDataSource1",OpenDataSource.class);
		Assert.assertNotEquals(null, bean);
		System.out.println(bean);
	}
	@Test
	public void openDataSource2() {
		OpenDataSource bean = ctx.getBean("openDataSource2",OpenDataSource.class);
		Assert.assertNotEquals(null, bean);
		System.out.println(bean);
	}
	@Test
	public void c3p0DataSource() {
		ComboPooledDataSource bean = ctx.getBean("c3p0DataSource",ComboPooledDataSource.class);
		Assert.assertNotEquals(null, bean);
		System.out.println(bean);
	}
	@Test
	public void druidDataSource() throws SQLException {
		DruidDataSource bean = ctx.getBean("druidDataSource",DruidDataSource.class);
		Assert.assertNotEquals(null, bean);
		System.out.println(bean.getConnection());
	}
	@After
	public void close() {
		ctx.close();

	}
	
}	
