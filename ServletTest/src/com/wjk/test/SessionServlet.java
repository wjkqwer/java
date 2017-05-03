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
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//flase只是去取Session，不存在的话不会去创建；true取Session，不存在会创建
		HttpSession mySession=request.getSession(true);

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session测试</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Session信息</h3>");
		out.println("是否是新Session："+mySession.isNew());
		out.println("<br/>Session ID："+mySession.getId());
		out.println("<br/>Session创建时间："+new Date(mySession.getCreationTime()));
		out.println("<br/>Session最后使用时间："+new Date(mySession.getLastAccessedTime()));
		out.println("<h3>发送的Session信息</h3>");
		out.println("要发送给服务器的Session ID："+request.getRequestedSessionId());
		out.println("<br/>是否有保存在Cookie中的Session ID："+request.isRequestedSessionIdFromCookie());
		out.println("<br/>是否有保存在URL中的Session ID："+request.isRequestedSessionIdFromURL());
		out.println("<br/>是否有有效的Session ID："+request.isRequestedSessionIdValid());
		out.println("<br/><a href="+response.encodeURL("SessionServlet")+">refresh</a>"); //1转码  2在url后面加入SessionId(在浏览器不支持Cookie时，才会在url后加SessionId)
		out.println("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
