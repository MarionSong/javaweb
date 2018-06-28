package com.jt.common.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	/**
	 * 启动加载类，Tomcat启动时，会自动加载类路径中的/META-INF/services/javax.servlet.ServletContainerInitializer资源
	 * 加载文件中定义的类，类上使用的@HandleType
	 * 注解定义的类的所有子类
	 */
	/**
	 * 此方法可以有选择的重写
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("onStartup");
		// 此方法内部在注册前端控制器
		super.onStartup(servletContext);
	}
	/**
	 * 官方建议在此方法中
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses");
		return null;
	}
	/**
	 * 此方法用于加载springmvc组件
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses");
		return new Class[] {AppServletConfig.class};
	}
	/**
	 * 此方法中定义请求URL的拦截
	 */
	
	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings");
		return  new String[] {"*.do"};
	}
	
}
