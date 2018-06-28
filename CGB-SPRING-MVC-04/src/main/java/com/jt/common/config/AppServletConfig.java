package com.jt.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//充当spring-config.xml
@ComponentScan("com.jt")//扫描指定包以及子包
@EnableWebMvc//注解方式启用mvc默认配置
public class AppServletConfig extends WebMvcConfigurerAdapter{
	/**配置视图解析器*/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages", ".jsp");
	}
	
	
	
	
	
}//假如希望在Tomcat启动时被加载
