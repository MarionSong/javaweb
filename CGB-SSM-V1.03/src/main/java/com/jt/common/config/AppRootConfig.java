package com.jt.common.config;



import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@ComponentScan(value="com.jt",excludeFilters= 
	{@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})})
@PropertySource(value="classpath:configs.properties")
//@Configuration
@MapperScan(basePackages="com.jt.**.dao")
public class AppRootConfig {
	/**
	 * 配置数据源对象
	 * @param driverClass
	 * @param jdbcUrl
	 * @param username
	 * @param password
	 * @return
	 */
	
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")
	public DataSource newDruidDataSource(
			@Value("${jdbcDriver}")   String driverClass,
			@Value("${jdbcUrl}")      String jdbcUrl,
			@Value("${jdbcUser}")     String username,
			@Value("${jdbcPassword}") String password) {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	
	}
	
	@Bean("sqlSessionFactoryBean")
	public SqlSessionFactoryBean newSqlSessionFactoryBean(DataSource dataSource ) throws IOException {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
			.getResources("classpath:mapper/sys/*.xml");
		bean.setMapperLocations(mapperLocations);
		return bean;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
