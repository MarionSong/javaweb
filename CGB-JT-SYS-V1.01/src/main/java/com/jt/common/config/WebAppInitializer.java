package com.jt.common.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**此类中负责执行前端控制器以及相关bean组件的加载和注册
 * 说明：此对象要承担web.xml的作用
 * */
public class WebAppInitializer 
       extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
	}
	/**
	 * 此方法加载service,dao等相关bean对象
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppRootConfig.class};
	}
	/**
	 * 此方法中负责加载spring mvc 中的v,c等相关组件
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppServletConfig.class};
	}
	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.do"};
	}
}
