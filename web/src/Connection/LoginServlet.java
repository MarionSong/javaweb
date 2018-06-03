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
 *��������������û���¼
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //����������롢��Ӧ��ʽ�ͱ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ptst = null;
		//��ȡ��¼ҳ���ύ������
		String loginName = request.getParameter("username");
		String loginPassword = request.getParameter("password");
		//sql���
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
			//�жϼ������Ƿ����username
			if(list.contains(loginName)) {
				//����username��Ӧ��password
				List<String> passwordList = new ArrayList<String>();
				ptst = (PreparedStatement) conn.prepareStatement(password);
				//����ptst����
				ptst.setString(1, loginName);
				rs = ptst.executeQuery();
				while (rs.next()) {
					passwordList.add(rs.getString(1));
				}
				//�ж����ݿ����¼ҳ���ύ��password�Ƿ�һ��
				if (passwordList.get(0).equals(loginPassword)) {
					out.println("��ӭ��¼��");
				} else {
					out.println("������������³��ԡ�");
				}
			}else {
				out.println("�û���������");
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