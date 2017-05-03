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

		//flaseֻ��ȥȡSession�������ڵĻ�����ȥ������trueȡSession�������ڻᴴ��
		HttpSession mySession=request.getSession(true);

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Session����</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Session��Ϣ</h3>");
		out.println("�Ƿ�����Session��"+mySession.isNew());
		out.println("<br/>Session ID��"+mySession.getId());
		out.println("<br/>Session����ʱ�䣺"+new Date(mySession.getCreationTime()));
		out.println("<br/>Session���ʹ��ʱ�䣺"+new Date(mySession.getLastAccessedTime()));
		out.println("<h3>���͵�Session��Ϣ</h3>");
		out.println("Ҫ���͸���������Session ID��"+request.getRequestedSessionId());
		out.println("<br/>�Ƿ��б�����Cookie�е�Session ID��"+request.isRequestedSessionIdFromCookie());
		out.println("<br/>�Ƿ��б�����URL�е�Session ID��"+request.isRequestedSessionIdFromURL());
		out.println("<br/>�Ƿ�����Ч��Session ID��"+request.isRequestedSessionIdValid());
		out.println("<br/><a href="+response.encodeURL("SessionServlet")+">refresh</a>"); //1ת��  2��url�������SessionId(���������֧��Cookieʱ���Ż���url���SessionId)
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
