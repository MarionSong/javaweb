package Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *这个类用来处理注册信息
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码、响应方式和编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		List<String> list=new ArrayList<String>();
		//获取注册用户名
		String username=request.getParameter("username");
		//获取注册用户密码
		String password=request.getParameter("password");
		//获取确认密码
		String repeatPsd=request.getParameter("repeatPsd");
		//获取真实姓名
		String truename=request.getParameter("truename");
		//获取用户姓名
		String gender=request.getParameter("gender");
		//获取注册手机号
		String phone=request.getParameter("phone");
		//获取身份证号码
		String identity=request.getParameter("identity");
		Connection conn=null;
		try {
			conn=JDBCUtils.getConnection();
			//判断两次输入的密码是否一致
			if(password.equals(repeatPsd)) {
				//判断用户列表中是否已经存在该用户
				String str="select username from message";
				st=conn.createStatement();
				rs=st.executeQuery(str);
				while(rs.next()) {
					list.add(rs.getString(1));
				}
				if(list.contains(username)) {
					out.println("用户名已被注册");
				}else {
					String sql="insert into message(username,password,name,gender,phonenumber,identitycode) values(?,?,?,?,?,?)";
					ps=conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, truename);
					ps.setString(4,gender);
					ps.setString(5, phone);
					ps.setString(6, identity);
					ps.execute();
					out.println("欢迎注册");	
				}			
			}else {
				out.println("两次输入的密码不一致，请重新输入");
			}
	
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			JDBCUtils.close(conn, st, rs);
		}
		out.flush();
		out.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}