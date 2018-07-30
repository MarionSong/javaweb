package com.marion.common.factory;


import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClusterFactory implements FactoryBean<JedisCluster>{
	
	private Resource propertySource;			//定义获取pro的数据源
	private JedisPoolConfig poolConfig; //定义config配置文件
	private String redisNodePrefix;				//定义配置文件前缀
	
	public String getRedisNodePrefix() {
		return redisNodePrefix;
	}

	public void setRedisNodePrefix(String redisNodePrefix) {
		this.redisNodePrefix = redisNodePrefix;
	}

	public Resource getPropertySource() {
		return propertySource;
	}

	public void setPropertySource(Resource propertySource) {
		this.propertySource = propertySource;
	}

	
	
	public JedisPoolConfig getPoolConfig() {
		return poolConfig;
	}

	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	//定义如何从source源中获取需要的Set集合
	public Set<HostAndPort> getNodes(){
		Set<HostAndPort> sets = new HashSet<HostAndPort>();
		
		try {
			//加载配置文件
			Properties properties = new Properties();
			properties.load(propertySource.getInputStream());	//加载资源文件
			
			//循环遍历key的值
			for (Object key : properties.keySet()) {
				String propertyKey = (String) key;
				
				//正则判断 是否为集群的配置key 如果不是 则继续下一次循环
				if(!propertyKey.startsWith(redisNodePrefix)){
					//如果不匹配进入下一次循环
					continue;
				}
				
				//获取集群的配置value值  redis.cluster0=192.168.126.151:7000
				String value = properties.getProperty(propertyKey);
				String[] args = value.split(":");
				//为hostAndPort进行赋值操作
				HostAndPort hostAndPort = new HostAndPort(args[0], Integer.parseInt(args[1]));
				sets.add(hostAndPort);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sets;
	}

	@Override
	public JedisCluster getObject() throws Exception {
		Set<HostAndPort> nodes = getNodes();
		JedisCluster jedisCluster = new JedisCluster(nodes, poolConfig);
		return jedisCluster;
	}

	@Override
	public Class<?> getObjectType() {

		return JedisCluster.class;
	}

	@Override
	public boolean isSingleton() {
		//表示单例设计模式
		return true;
	}
}
