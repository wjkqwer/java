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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloFrom() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		// ������Ӧ��������
//		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		//������ύ����������������������Ҫת�룺
		String title=new String(request.getParameter("title").getBytes("ISO8859-1"),"UTF-8");
		String name=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
				
		String docType = "<!DOCTYPE html> \n";
		out.println(docType+
				"<html>\n" +
			    "<head><title>" + title + "</title></head>\n" +
			    "<body bgcolor=\"#f0f0f0\">\n" +
			    "<h1 align=\"center\">" + title + "</h1>\n" +
			    "<ul>\n" +
			    "  <li><b>վ����</b>��"
			    + name + "\n" +
			    "  <li><b>��ַ</b>��"
			    + request.getParameter("url") + "\n" +
			    "</ul>\n" +
			    "<ul>\n" +
	            "  <li><b>�ٶȣ�</b>: "
	            + request.getParameter("baidu") + "\n" +
	            "  <li><b>�ȸ裺</b>: "
	            + request.getParameter("google") + "\n" +
	            "  <li><b>��Ӧ��</b>: "
	            + request.getParameter("bing") + "\n" +
	            "</ul>\n" +
			    "</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
