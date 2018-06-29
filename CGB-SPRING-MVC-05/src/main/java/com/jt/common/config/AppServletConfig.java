package com.jt.common.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jt.login.LogInterceptor;
import com.jt.sys.interceptor.Timeinterceptor;

//充当spring-config.xml
@ComponentScan("com.jt")//扫描指定包以及子包
@EnableWebMvc//注解方式启用mvc默认配置
public class AppServletConfig extends WebMvcConfigurerAdapter{
	/**配置视图解析器*/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/pages", ".jsp");
	}
	
	/**
	 * 注册HTTPMessageConverter对象为alibaba的fastjson中的转换器对象
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//构建HttpMessageConverter对象
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		converters.add(converter);
	}
	/**
	 * 配置spring拦截器
	 * 
	 */
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//构建拦截器对象
		Timeinterceptor ti = new Timeinterceptor();
		//注册拦截器
		registry.addInterceptor(ti).addPathPatterns("/**")//拦截所有
		.excludePathPatterns("/resp/doHandle01.do");//排除拦截
		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/resp/doHandle01.do");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//假如希望在Tomcat启动时被加载
