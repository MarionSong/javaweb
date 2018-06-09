package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.web.utils.JDBCUtils;

/**
 *这个类用来删除商品信息
 */
public class ProdDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码格式
		response.setContentType("text/html;charset=utf-8");
		//通过ID获取商品
		int id=Integer.parseInt(request.getParameter("id"));
		//删除商品
		delProd(id);
		response.getWriter().write("<h1 style='color:red;text-algin:center'>");
		response.getWriter().write("删除信息成功");
		response.getWriter().write("</h1>");
		
	}

	private void delProd(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="delete from product where id=?";
		try {
			conn=JDBCUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品删除失败");
		}finally {
			JDBCUtils.close(conn, ps, rs);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}