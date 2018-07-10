package com.jt.common.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**此类中负责执行前端控制器以及相关bean组件的加载和注册
 * 说明：此对象要承担web.xml的作用
 * */
public class WebAppInitializer 
       extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerContextLoaderListener(servletContext);
		registerFilter(servletContext);
		registerDispatcherServlet(servletContext);
	}
	private void registerFilter(ServletContext servletContext) {
		//注册Filter对象
		//什么时候需要采用此方式进行注册?
		//项目没有web.xml并且此filter不是自己写的
		FilterRegistration.Dynamic dy=
		servletContext.addFilter("filterProxy",
				DelegatingFilterProxy.class);
		dy.setInitParameter("targetBeanName","shiroFilterFactoryBean");
		dy.addMappingForUrlPatterns(
				null,//EnumSet<DispatcherType>
				false,"/*");//url-pattern
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
