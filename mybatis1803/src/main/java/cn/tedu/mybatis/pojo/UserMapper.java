package cn.tedu.mybatis.pojo;

import java.util.List;

//必须和映射文件同一个路径
public interface UserMapper {
	public List<User> find(User user); 
	public void insert(User user);
	public void update(User user);
	public void delete(List list);
	
	
	
	
}
