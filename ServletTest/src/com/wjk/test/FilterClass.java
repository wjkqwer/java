package com.wjk.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloFilter
 */
@WebServlet("/FilterClass")
public class FilterClass implements Filter {

	String contentType;

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		contentType = config.getInitParameter("contentType");

		// 输出初始化参数
		System.out.println("名称: " + contentType);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter");
		
		//例:在这里设置ContentType，然后把此过滤器设置为适用所有Servlet，就不用在每个Servlet中都写同样的代码
		response.setContentType(contentType);

		// 在这里进行过滤处理，完成后在把请求传回过滤链
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
