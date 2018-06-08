package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tedu.jt.web.utils.JDBCUtils;

/**
*这个类用来查询数据库中的商品信息
*/
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询所有商品信息，返回所有商品组成的list集合
		List<Product> list=findProdList();
		
		
		//将List集合存到request域中
		request.setAttribute("list", list);		
		
		//通过转发将所有商品信息带到jsp展示
		request.getRequestDispatcher("/backend/prod_list.jsp").forward(request, response);	
		
	}

	private List<Product> findProdList() {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from product";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			//将结果集记录转成存放商品对象的List集合
			Product prod=null;
			List<Product> list=new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String category=rs.getString(3);
				double price =rs.getDouble(4);
				int pnum=rs.getInt(5);
				String description=rs.getString(6);		
				prod=new Product(id, name, category, price, pnum, description);
				list.add(prod);			
			}
			
		return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, stat, rs);
		}
		
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
