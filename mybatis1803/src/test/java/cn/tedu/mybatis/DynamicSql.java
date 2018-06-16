package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.mybatis.pojo.User;

public class DynamicSql {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(is);		
	}
	@Test
	public void find() {
		SqlSession session = factory.openSession();
		Map<String,Object> map=new HashMap<>();
		map.put("id", "5");
		map.put("name", "张居正");
		User user = session.selectOne("cn.tedu.mybatis.pojo.UserMapper.search",map);
		
			System.out.println(user);
		
	}
	@Test
	public void update() {
		SqlSession session = factory.openSession();
		Map<String,Object> map=new HashMap<>();
		map.put("name", "张居正");		
		map.put("address", "皇宫");
		map.put("id", "5");
		session.update("cn.tedu.mybatis.pojo.UserMapper.search",map);		
	}
	
	@Test
	public void insert() {
		SqlSession session = factory.openSession();
		User user=new User();
		user.setId("7");
		user.setName("唐三");
		user.setAddress("天斗帝国");
		user.setAge(15);
		session.update("cn.tedu.mybatis.pojo.UserMapper.insert",user);	
		session.commit();
	}
	
	@Test
	public void delete() {
		SqlSession session = factory.openSession();
		List<String> list=new ArrayList<>();
		list.add("6");
		list.add("7");
		session.delete("cn.tedu.mybatis.pojo.UserMapper.delete", list);
		session.commit();
	}
	
	
	
	
	
}
