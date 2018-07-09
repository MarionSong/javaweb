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
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.pool.DruidDataSource;
@PropertySource(value="classpath:configs.properties")
@ComponentScan(value="com.jt",excludeFilters= {@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})})
@MapperScan(basePackages="com.jt.**.dao")//配置扫描
public class AppRootConfig {
	//配置数据源对象
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")
	public DataSource newDruidDataSource(
			@Value("${jdbcDriver}")String driverClass,
			@Value("${jdbcUrl}")String jdbcUrl,
			@Value("${jdbcUser}")String username,
			@Value("${jdbcPassword}")String password
			) {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactoryBean(@Autowired
			DataSource dataSource) throws IOException {//把上面返回的dataSource自动装配到DataSource
		//1.构建对象(通过此对象获取SqlSessionFactory)
		SqlSessionFactoryBean sBean= new SqlSessionFactoryBean();
		//2.设置数据源对象
		sBean.setDataSource(dataSource);//把dataSource注入工厂对象
		Resource[] mapperLocations= 
				new PathMatchingResourcePatternResolver().getResources(
						"classpath:mapper/sys/*.xml");
		//3.设置mybatis映射文件的资源路径
		sBean.setMapperLocations(mapperLocations);
		return sBean;
	}
}
