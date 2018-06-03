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
 *这个类用来处理用户登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //设置请求编码、响应方式和编码方式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ptst = null;
		//获取登录页面提交的数据
		String loginName = request.getParameter("username");
		String loginPassword = request.getParameter("password");
		//sql语句
		String username = "select username from message";
		String password = "select password from message where username = ?";
		try {
			conn=JDBCUtils.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(username);
			List<String> list=new ArrayList<String>();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			//判断集合中是否存在username
			if(list.contains(loginName)) {
				//查找username对应的password
				List<String> passwordList = new ArrayList<String>();
				ptst = (PreparedStatement) conn.prepareStatement(password);
				//设置ptst参数
				ptst.setString(1, loginName);
				rs = ptst.executeQuery();
				while (rs.next()) {
					passwordList.add(rs.getString(1));
				}
				//判断数据库与登录页面提交的password是否一致
				if (passwordList.get(0).equals(loginPassword)) {
					out.println("欢迎登录。");
				} else {
					out.println("密码错误，请重新尝试。");
				}
			}else {
				out.println("用户名不存在");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtils.close(conn, ptst, rs);
		}
		out.flush();
		out.close();

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}