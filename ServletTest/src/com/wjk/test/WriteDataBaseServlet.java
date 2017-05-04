package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteDataBaseServlet
 */
@WebServlet("/WriteDataBaseServlet")
public class WriteDataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/myTest";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement ps = null;
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>写入数据库</title>");
		out.println("</head>");
		out.println("<body>");

		// 编写预处理 SQL 语句
		String sql = "INSERT INTO people VALUES(?,?,?,?,?)";

		// 实例化 PreparedStatement
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			// 打开一个连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(request.getParameter("name"));
			ps = conn.prepareStatement(sql);
			
			// 传入参数，这里的参数来自于一个带有表单的jsp文件，很容易实现
			ps.setString(1, request.getParameter("id"));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("age"));
			ps.setString(4, request.getParameter("sex"));
			ps.setString(5, request.getParameter("country"));
			// 执行数据库更新操作，不需要SQL语句
			ps.executeUpdate();

			out.println("<a href=\"DataBaseServlet\">跳转DataBaseServlet查看</a>");

			out.println("</body></html>");

			// 完成后关闭
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
