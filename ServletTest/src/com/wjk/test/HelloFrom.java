package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloFrom
 */
@WebServlet("/HelloFrom")
public class HelloFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		// 设置响应内容类型,这设置了过滤
//		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		//如果表单提交的数据中有中文数据则需要转码：
		String title=new String(request.getParameter("title").getBytes("ISO8859-1"),"UTF-8");
		String name=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		String url=new String(request.getParameter("url").getBytes("ISO8859-1"),"UTF-8");
				
		String docType = "<!DOCTYPE html> \n";
		out.println(docType+
				"<html>\n" +
			    "<head><title>" + title + "</title></head>\n" +
			    "<body bgcolor=\"#f0f0f0\">\n" +
			    "<h1 align=\"center\">" + title + "</h1>\n" +
			    "<ul>\n" +
			    "  <li><b>站点名</b>："
			    + name + "\n" +
			    "  <li><b>网址</b>："
			    + url + "\n" +
			    "</ul>\n" +
			    "<ul>\n" +
	            "  <li><b>百度：</b>: "
	            + request.getParameter("baidu") + "\n" +
	            "  <li><b>谷歌：</b>: "
	            + request.getParameter("google") + "\n" +
	            "  <li><b>必应：</b>: "
	            + request.getParameter("bing") + "\n" +
	            "</ul>\n" +
				"</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
