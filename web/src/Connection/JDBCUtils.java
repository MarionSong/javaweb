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
 * �������jdbc�Ĺ�����
 */
public class JDBCUtils {

	//1,�޲ι��캯��˽�л����������ֱ��new����
	private JDBCUtils(){}
	private static ComboPooledDataSource pool=new ComboPooledDataSource();
	
	
	//2,�ṩ��̬��getConnection����java.sql.Connection
	public static Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
	//3,�ṩ��̬��close����
	public static void close(
			Connection conn,
				Statement st,
					ResultSet rs){
		//��ֹ��ָ���쳣
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				rs = null;
			}
		}
		//��ֹ��ָ���쳣
		if(st != null ){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				st = null;
			}
		}
		//��ֹ��ָ���쳣
		if(conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				conn = null;
			}
		}
		
	}
	
	
	
	
}
