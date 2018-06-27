package com.jt.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//spring-configs.xml
@ComponentScan("com.jt")
@EnableWebMvc
public class AppServletConfig extends WebMvcConfigurerAdapter{
	/**配置视图解析器*/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages", ".jsp");
	}
	
	
	
	
}
