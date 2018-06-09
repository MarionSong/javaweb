package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.web.utils.JDBCUtils;

/**
 *这个类用来在修改时查询商品
 */
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取商品id
		int id=Integer.parseInt(request.getParameter("id"));
		//根据ID查找商品信息
		Product prod=findProdById(id);
		//把商品信息存入request域中
		request.setAttribute("prod", prod);
		//通过转发将商品信息带到prod_upd.jsp进行修改
		request.getRequestDispatcher("/backend/prod_upd.jsp").
		forward(request, response);
	}

	private Product findProdById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from product where id=?";
		try {
			//连接数据库
			conn=JDBCUtils.getConn();
			//获取传输器
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			//执行sql
			rs=ps.executeQuery();
			
			Product prod=null;
			//解析sql
			while(rs.next()) {
				prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setCategory(rs.getString(3));
				prod.setPrice(rs.getDouble(4));
				prod.setPnum(rs.getInt(5));
				prod.setDescription(rs.getString(6));
			}
			return prod;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品查询失败");
		}finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}