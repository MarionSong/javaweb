package com.songming.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan("com.songming")
@PropertySource("classpath:configs.properties")
public class AppConfig {
	@Bean("datasource")
	public DruidDataSource druidDataSource(
			@Value("${driver}")   String driverClassName,
			@Value("${url}")  String url,
			@Value("${user}")     String username,
			@Value("${password}") String password
			) {
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		Resource[] mapperLocations=new PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/sys/*.xml");
		bean.setMapperLocations(mapperLocations);
		return bean;
		
	}
	
	@Bean("mapper")
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapper=new MapperScannerConfigurer();
		mapper.setBasePackage("com.songming.juice.dao");	
		mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapper;
	}
	
	
	
	
	
	
	
	
}
