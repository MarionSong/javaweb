package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.mybatis.pojo.User;
import cn.tedu.mybatis.pojo.UserMapper;

public class TestIn {
	private SqlSessionFactory factory;
	
	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void find() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		List<User> list=mapper.find(user);
		for(User u:list) {
			System.out.println(u);	
		}

	}
	@Test
	public void insert() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setId("6");
		user.setName("宋铭");
		user.setAge(18);
		user.setAddress("吉林");
		mapper.insert(user);
		session.commit();
	}
	
	@Test
	public void update() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setId("6");
		user.setAddress("吉林省");
		mapper.update(user);
		session.commit();
	}
	
	@Test
	public void delete() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<String> list=new ArrayList<>();
		list.add("6");
		mapper.delete(list);
		session.commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
