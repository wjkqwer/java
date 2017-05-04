package com.wjk.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/myTest";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";

	public static Connection getConn() {
		Connection connection = null;
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			// 打开一个连接
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static Statement getStatement(Connection conn) {
		Statement statement = null;
		try {
			if (conn != null) {
				statement = conn.createStatement();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return statement;
	}
	
	
	public static ResultSet getResultSet(Statement stmt,String sql){
		ResultSet result=null;
		try {
			if(stmt!=null){
				result=stmt.executeQuery(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}






































