package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");
        
		Cookie nameCookie = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8"));
		Cookie urlCookie = new Cookie("url", URLEncoder.encode(request.getParameter("url"), "UTF-8"));

		// ����nameCookie�������ڣ�urlCookie������
		nameCookie.setMaxAge(60 * 60 * 24);

		// ����Ӧͷ��������� Cookie
		response.addCookie(nameCookie);
		response.addCookie(urlCookie);
		
		PrintWriter out = response.getWriter();
		String title = "���� Cookie ʵ��";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
		        "<html>\n" +
		        "<head><title>" + title + "</title></head>\n" +
		        "<body bgcolor=\"#f0f0f0\">\n" +
		        "<h1 align=\"center\">" + title + "</h1>\n" +
		        "<ul>\n" +
		        "  <li><b>name��</b>��"
		        + request.getParameter("name") + "\n</li>" +
		        "  <li><b>URL��</b>��"
		        + request.getParameter("url") + "\n</li>" +
		        "</ul>\n" +
		        "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
