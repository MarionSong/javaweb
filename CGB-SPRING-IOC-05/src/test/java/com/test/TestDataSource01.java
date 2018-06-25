package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jt.common.config.AppConfig;
import com.jt.common.util.OpenDataSource;

public class TestDataSource01 {
	public static void main(String[] args) {
		//构建context对象
		AnnotationConfigApplicationContext context 
				= new AnnotationConfigApplicationContext(AppConfig.class);
		//获取bean对象并输出
		OpenDataSource bean = context.getBean("openDataSource",OpenDataSource.class);
		System.out.println(bean);
		//关闭时才会执行destory
		context.close();
	}
}
