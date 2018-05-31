package day13;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String date=new Date().toString();
			response.getWriter().write(date);
			count++;
			System.out.println(count);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
