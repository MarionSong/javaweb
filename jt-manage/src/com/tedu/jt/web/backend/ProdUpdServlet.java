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
 *这个类是用来修改商品信息
 */
public class ProdUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取商品信息
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		double price=Double.parseDouble(request.getParameter("price"));
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		String description=request.getParameter("description");
		//修改商品信息
		updateProduct(id,name,category,price,pnum,description);
		response.getWriter().write("<h1 style='color:red;text-algin:center'>");
		response.getWriter().write("修改信息成功");
		response.getWriter().write("</h1>");
	}


	private void updateProduct(int id, String name, String category, double price, int pnum, String description) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConn();
			String sql="Update product set name=?,category=?,price=?,pnum=?,description=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			ps.setInt(6, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品修改失败");
		}finally {
			JDBCUtils.close(conn, ps, rs);
		}
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}