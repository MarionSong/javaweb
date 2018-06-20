package cn.tedu.spring_01;

import org.springframework.beans.factory.FactoryBean;

public class ObjectFactoryBean implements FactoryBean<ObjectFactory>{

	@Override
	public ObjectFactory getObject() throws Exception {
		System.out.println("getObject()");
		return new ObjectFactory();
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("getObjectType");
		return ObjectFactory.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("isSingleton");
		return false;
	}

}
