package cn.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
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

public class TestMybatis {
	private SqlSessionFactory factory;
	
	@Before
	public void init() throws IOException {
		InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
		factory=new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void testFind() throws IOException {
		//创建SqlSession对象
		SqlSession sqlsession=factory.openSession();
		//selectList查询，找到映射文件，找到其中一个方法
		List<User> userList=sqlsession.selectList("cn.tedu.mybatis.pojo.UserMapper.find");
		for(User s:userList) {
			System.out.println(s);
		}
	}
	@Test
	public void insert() throws IOException {
		SqlSession session = factory.openSession();
		session.insert("cn.tedu.mybatis.pojo.UserMapper.insert");
		session.commit();
		
	}
	@Test
	public void update() throws IOException {
		SqlSession session = factory.openSession();
		session.update("cn.tedu.mybatis.pojo.UserMapper.update","宋铭");
		session.commit();
		
		
	}
	@Test 
	public void delect() throws IOException {
		SqlSession session = factory.openSession();
		session.delete("cn.tedu.mybatis.pojo.UserMapper.delete");
		session.commit();
	}
	@Test
	public void get() throws IOException {
		SqlSession session=factory.openSession();
		String statement="cn.tedu.mybatis.pojo.UserMapper.get";
		session.selectOne(statement, "夏言");
	}
	
}
