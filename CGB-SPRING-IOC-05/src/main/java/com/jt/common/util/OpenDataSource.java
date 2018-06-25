package com.jt.common.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Lazy
@Scope("singleton")
@Component("openDataSource")//这是一个一般的bean组件对象，需要有spring管理
public class OpenDataSource {
	/**
	 * @PostConstruct注解用于定义生命周期方法中的初始化方法,jdk中的注解
	 */
	
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	/**
	 * @PreDestory注解用来定义生命周期方法中的销毁方法,jdk中的注解
	 */
	@PreDestroy
	public void destory() {
		System.out.println("destory()");
	}
	
	
	
}
