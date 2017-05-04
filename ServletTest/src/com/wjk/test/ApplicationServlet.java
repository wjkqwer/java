package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		ServletContext application=this.getServletContext();
		
		//从Attribute中取key为accessCount的值
		Integer accessCount=(Integer) application.getAttribute("accessCount");
		if(accessCount==null) {
			accessCount=new Integer(0);
		}else{
			accessCount=new Integer(accessCount.intValue()+1);
		}
		
		application.setAttribute("accessCount", accessCount);

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session全局追踪</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Session全局追踪</h3>");
		out.println("<h4>次数："+accessCount+"</h4>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
