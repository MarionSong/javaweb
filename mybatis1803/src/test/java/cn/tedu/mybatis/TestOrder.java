package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.mybatis.pojo.Order;
import cn.tedu.mybatis.pojo.OrderMapper;

public class TestOrder {
	private SqlSessionFactory factory;
	
	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		factory=new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void get() {
		SqlSession session = factory.openSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		Order order = mapper.get(1);
		System.out.println(order);
	}
	
	
}
