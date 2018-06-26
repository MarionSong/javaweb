package com.jt.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 定义spring中的配置类，相当于spring-configs.xml配置文件
 * @ComponectScan 注解用于定义在那些包中扫描指定的类
 * @Configuration 表示这个类是配置类
 */
@Configuration
@ComponentScan("com.jt")
@PropertySource("classpath:configs.properties")
public class AppConfig {
	/**
	 * @Bean 用于修饰系统引入的第三方资源,将这个资源交给spring管理,当使用@bean没有指定名字时，默认名字为
	 * 方法名
	 * @return
	 */
	
	@Bean("dataSource")
	public DruidDataSource newDruidDataSource(
			@Value("${driver}")     String driverClassName,
			@Value("${jdbcurl}")    String url,
			@Value("${user}")       String username,
			@Value("${password}")   String password) {
		DruidDataSource dataSource=new DruidDataSource();
		/*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///jtsys");
		dataSource.setUsername("root");
		dataSource.setPassword("root");*/
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;

	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException {
		//构建对象，通过此对象获得SQLSessionFactory
		SqlSessionFactoryBean sBean = new SqlSessionFactoryBean();
		//构建数据源对象
		sBean.setDataSource(dataSource);
		/*Resource[] mapperLocations= {
				new FileSystemResource("target/classes/mapper/sys/SysConfigMapper.xml")
		};*/
		Resource[] mapperLocations=new  PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/sys/*.xml");
		//设置mybatis映射文件的资源路径
		sBean.setMapperLocations(mapperLocations);
		
		return sBean;
		
		
	}
	@Bean
	
	public MapperScannerConfigurer newMapperScannerConfigurer() {
		MapperScannerConfigurer mapper=new MapperScannerConfigurer();
		mapper.setBasePackage("com.jt.sys.dao");	
		mapper.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapper;
	}
	
	
	
	
	
	
	
	
}
