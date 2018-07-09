package com.jt.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//这个类充当spring-configs.xml
@ComponentScan(value="com.jt",includeFilters= {
@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})},
useDefaultFilters=false) // <context:component-scan base-package="com.jt"/>
@EnableWebMvc // <mvc:annotation-driven/>
public class AppServletConfig extends WebMvcConfigurerAdapter{
	//配置视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages/", ".html");
		
	}
}
