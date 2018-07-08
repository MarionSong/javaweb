package com.jt.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * 
 * @author cgb1803
 *
 */
public class WebAppInitializer extends 	AbstractAnnotationConfigDispatcherServletInitializer{
	/**
	 * 此方法负责加载service，dao等相关bean对象
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {AppRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}
	
}
