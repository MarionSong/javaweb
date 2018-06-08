package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.web.utils.JDBCUtils;



/**
*负责处理商品的添加请求
*/
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取要添加的商品信息
		String name = request.getParameter("name");
		String category=request.getParameter("category");
		double price=Double.parseDouble(request.getParameter("price"));
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		String description=request.getParameter("description");
		
		//2.将商品信息保存到数据库中
		addProd(name,category,price,pnum,description);
		
		
		//3.提示用户商品添加成功
		response.getWriter().write("<h1 style='text-align:center;color:blue;'>");
		response.getWriter().write("商品添加成功");	
		response.getWriter().write("</h1>");
		
		//4.跳转到商品列表页面(定时刷新)
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"backend/prod_list.jsp");
		
	}
	/**
	 * 负责将商品信息保存到数据库中
	 * @param name 商品名称
	 * @param category 商品分类
	 * @param price 商品单价
	 * @param pnum 商品库存数量
	 * @param description 商品描述
	 */
	private void addProd(String name, String category, double price, int pnum, String description) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//从连接池中获取一个连接对象
			conn=JDBCUtils.getConn();
			//获取传输器
			String sql="insert into product values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//设置sql
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setDouble(4, price);
			ps.setInt(5, pnum);
			ps.setString(6, description);
			//执行sql
			ps.executeUpdate();
	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			JDBCUtils.close(conn, ps, rs);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
