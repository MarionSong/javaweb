package com.jt.common.config;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.apache.shiro.mgt.SecurityManager;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value="classpath:configs.properties")
@ComponentScan(value="com.jt",
excludeFilters={@Filter(type=FilterType.ANNOTATION,classes={Controller.class})})
@MapperScan(basePackages="com.jt.**.dao")
public class AppRootConfig {//service,dao

	@Bean
	public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
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

	@Bean("securityManager")
	public DefaultWebSecurityManager  newDefaultWebSecurityManager(
			AuthorizingRealm userRealm){
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		//此时必须保证realm对象已经存在了
		sManager.setRealm(userRealm);
		return sManager;
	}

	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(
			SecurityManager securityManager){//shiro 包
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		//当此用户是一个非认证用户,需要先登陆进行认证
		bean.setLoginUrl("/doLoginUI.do");
		LinkedHashMap<String,String> fcMap=
				new LinkedHashMap<>();
		fcMap.put("/bower_components/**","anon");//anon表示允许匿名访问
		fcMap.put("/build/**", "anon");
		fcMap.put("/dist/**","anon");
		fcMap.put("/plugins/**","anon");
		fcMap.put("/doLogin.do","anon");
		fcMap.put("/doLogout.do ","logout");
		fcMap.put("/**", "authc");//必须授权才能访问
		bean.setFilterChainDefinitionMap(fcMap);
		return bean;
	}

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor newLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	@DependsOn(value="lifecycleBeanPostProcessor")
	@Bean
	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}


	@Bean
	public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor(
			SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor bean=
				new AuthorizationAttributeSourceAdvisor();
		bean.setSecurityManager(securityManager);
		return bean;
	}








}









