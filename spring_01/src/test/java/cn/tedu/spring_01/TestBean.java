package cn.tedu.spring_01;

import java.util.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	private ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	
	@Test
	public void testHello() {
		HelloService helloService = ctx.getBean("helloservice", HelloService.class);
		helloService.sayHello("mingming");
	}
	@Test
	public void testCalendar() {
		Calendar bean = ctx.getBean("calendar",Calendar.class);
		
	}
	
	@Test
	public void testDate() {
		Date bean = ctx.getBean("date",Date.class);
		System.out.println(bean);
	}
	
	@Test
	public void testFactory() {
		ObjectFactory of=(ObjectFactory)ctx.getBean("objectfactory");
		
		ObjectFactoryBean bean = ctx.getBean("&objectfactory",ObjectFactoryBean.class);
	
	}
	
	
	
	@After
	public void close() {
		ctx.close();
	}
}
