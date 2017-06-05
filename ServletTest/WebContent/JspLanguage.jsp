<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- 声明的为全局变量 -->
	<%!int count1 = 0;

	//可以在全局声明方法
	void test() {}
	%>


	<!-- 声明的为局部变量 -->
	<%
		int count2 = 0;

		//局部不允许声明方法，相当于在方法中在声明方法
		//void test(){}
	%>



	<h3>
		count1=<%=count1++%></h3>
	<h3>局部
		count2=<%=count2++%></h3>

</body>
</html>