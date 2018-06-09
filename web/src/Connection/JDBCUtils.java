package Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 这个类是jdbc的工具类
 */
public class JDBCUtils {

	//1,无参构造函数私有化，不让外界直接new对象
	private JDBCUtils(){}
	private static ComboPooledDataSource pool=new ComboPooledDataSource();
	
	
	//2,提供静态的getConnection方法java.sql.Connection
	public static Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
	//3,提供静态的close方法
	public static void close(
			Connection conn,
				Statement st,
					ResultSet rs){
		//防止空指针异常
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				rs = null;
			}
		}
		//防止空指针异常
		if(st != null ){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				st = null;
			}
		}
		//防止空指针异常
		if(conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				conn = null;
			}
		}
		
	}
	
	
	
	
}
