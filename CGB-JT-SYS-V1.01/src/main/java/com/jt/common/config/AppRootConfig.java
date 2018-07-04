package com.jt.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value="classpath:configs.properties")
@ComponentScan(value="com.jt",
excludeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})})
@MapperScan(basePackages="com.jt.**.dao")
public class AppRootConfig {//service,dao
     /**配置数据源对象:druid*/
	 @Bean(value="dataSource",initMethod="init",destroyMethod="close")
	 public DataSource newDruidDataSource(
			@Value("${jdbcDriver}")String driverClass,
			@Value("${jdbcUrl}")String jdbcUrl,
			@Value("${jdbcUser}")String username,
			@Value("${jdbcPassword}")String password){
		 DruidDataSource ds=new DruidDataSource();
		 ds.setDriverClassName(driverClass);
		 ds.setUrl(jdbcUrl);
		 ds.setUsername(username);
		 ds.setPassword(password);
		 //ds.setMaxActive(maxActive);
		 //ds.setMaxWait(maxWaitMillis);
		 //ds.setLoginTimeout(1);
		 return ds;
	 }
	 @Bean("sqlSessionFactory")
	 public SqlSessionFactoryBean newSqlSessionFactoryBean(
			 @Autowired DataSource dataSource) throws IOException{
		 SqlSessionFactoryBean fBean=new SqlSessionFactoryBean();
		 fBean.setDataSource(dataSource);
		 Resource[] mapperLocations=
		 new PathMatchingResourcePatternResolver()
		 .getResources("classpath:mapper/sys/*.xml");
		 fBean.setMapperLocations(mapperLocations);
		 return fBean;
	 }
	 
}









