package com.songming.juice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.songming.common.config.AppConfig;
import com.songming.juice.controller.JuiceController;
import com.songming.juice.pojo.Juice;

public class TestJuice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		JuiceController juice = context.getBean("juiceController",JuiceController.class);
		Juice findById = juice.findById(1);
		System.out.println(findById);
		context.close();
		
	}
}
