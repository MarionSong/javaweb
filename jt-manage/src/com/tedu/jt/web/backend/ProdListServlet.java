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
*杩欎釜绫荤敤鏉ユ煡璇㈡暟鎹簱涓殑鍟嗗搧淇℃伅
*/
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//鏌ヨ鎵�鏈夊晢鍝佷俊鎭紝杩斿洖鎵�鏈夊晢鍝佺粍鎴愮殑list闆嗗悎
		List<Product> list=findProdList();
		
		
		//灏哃ist闆嗗悎瀛樺埌request鍩熶腑
		request.setAttribute("list", list);		
		
		//閫氳繃杞彂灏嗘墍鏈夊晢鍝佷俊鎭甫鍒癹sp灞曠ず
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
			//灏嗙粨鏋滈泦璁板綍杞垚瀛樻斁鍟嗗搧瀵硅薄鐨凩ist闆嗗悎
			Product prod=null;
			List<Product> list=new ArrayList<Product>();
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
			System.out.println("商品查询失败");
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
