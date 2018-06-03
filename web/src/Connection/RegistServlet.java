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
 *�������������ע����Ϣ
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����������롢��Ӧ��ʽ�ͱ��뷽ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		List<String> list=new ArrayList<String>();
		//��ȡע���û���
		String username=request.getParameter("username");
		//��ȡע���û�����
		String password=request.getParameter("password");
		//��ȡȷ������
		String repeatPsd=request.getParameter("repeatPsd");
		//��ȡ��ʵ����
		String truename=request.getParameter("truename");
		//��ȡ�û�����
		String gender=request.getParameter("gender");
		//��ȡע���ֻ���
		String phone=request.getParameter("phone");
		//��ȡ���֤����
		String identity=request.getParameter("identity");
		Connection conn=null;
		try {
			conn=JDBCUtils.getConnection();
			//�ж���������������Ƿ�һ��
			if(password.equals(repeatPsd)) {
				//�ж��û��б����Ƿ��Ѿ����ڸ��û�
				String str="select username from message";
				st=conn.createStatement();
				rs=st.executeQuery(str);
				while(rs.next()) {
					list.add(rs.getString(1));
				}
				if(list.contains(username)) {
					out.println("�û����ѱ�ע��");
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
					out.println("��ӭע��");	
				}			
			}else {
				out.println("������������벻һ�£�����������");
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