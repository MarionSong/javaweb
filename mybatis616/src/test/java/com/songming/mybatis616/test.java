package com.songming.mybatis616;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.songming.mybatis616.pojo.Province;
import com.songming.mybatis616.pojo.ProvinceMapper;
import com.songming.mybatis616.pojo.User;
import com.songming.mybatis616.pojo.UserMapper;

public class test {
	private SqlSessionFactory factory;
	
	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("sqlMapperConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void find() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setName("宋铭");
		user = mapper.find(user);
		System.out.println(user);
	}
	
	/*@Test
	public void insert() {
		SqlSession session = factory.openSession();
		ProvinceMapper mapper = session.getMapper(ProvinceMapper.class);
		Province province=new Province();
		province.setAddress("天津");
		province.setTel(232);
		mapper.insert(province);
		session.commit();
		session.close();
	}*/
	@Test
	public void insert() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setId(9);
		user.setName("剑圣");
		user.setBirthday(new Date());
		user.setAddress("英雄联盟");
		mapper.insert(user);
		session.commit();
		session.close();
		
	}
	
	
	
	
	
}
