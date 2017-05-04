package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSession
 */
@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession mySession=request.getSession(true);
		String heading;
		Integer accessCount=(Integer) mySession.getAttribute("accessCount");
		if(accessCount==null) {
			accessCount=new Integer(0);
			heading="Welcome, NewComer";
		}else{
			accessCount=new Integer(accessCount.intValue()+1);
			heading="Welcome back";
		}
		
		mySession.setAttribute("accessCount", accessCount);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session追踪</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Session追踪,同一个浏览器窗口共享</h3>");
		out.println("<h3>"+heading+"</h3>");
		out.println("<h4>创建时间："+new Date(mySession.getCreationTime())+"</h4>");
		out.println("<h4>最后使用时间："+new Date(mySession.getLastAccessedTime())+"</h4>");
		out.println("<h4>次数："+accessCount+"</h4>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
