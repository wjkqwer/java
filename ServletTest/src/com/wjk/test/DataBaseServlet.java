package com.wjk.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataBaseServlet
 */
@WebServlet("/DataBaseServlet")
public class DataBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/myTest";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>读取数据库</title>");
		out.println("</head>");
		out.println("<body>");

		String sql = "SELECT id, name, age,sex,country FROM people";

		Connection connection = DataBaseConnection.getConn();
		Statement statement = DataBaseConnection.getStatement(connection);
		ResultSet result = DataBaseConnection.getResultSet(statement, sql);

		// 展开结果集数据库
		try {
			while (result.next()) {
				// 通过字段检索
				int id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				String sex = result.getString("sex");
				String country = result.getString("country");
				// 输出数据
				out.println("ID: " + id);
				out.println(" -- name: " + name);
				out.println(" -- age: " + age);
				out.println(" -- sex: " + sex);
				out.println(" -- country: " + country);
				out.println("<br />");
			}

			out.println("</body></html>");

			// 完成后关闭
			result.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
