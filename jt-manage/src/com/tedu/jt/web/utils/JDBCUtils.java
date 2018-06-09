package com.tedu.jt.web.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//工具类构造函数私有化
	private JDBCUtils() {}
	//声明一个连接池对象
	private static ComboPooledDataSource pool=new ComboPooledDataSource();
	/**
	 * 用于从连接池中获取一个连接并返回
	 * @return Connection对象
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
		return pool.getConnection();
	
	}
	/**
	 * 这个接口用于释放资源
	 * @param conn 连接对象
	 * @param stat 传输器对象
	 * @param rs  结果集对象
	 */
	public static void close(Connection conn,Statement ps,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ps=null;
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
