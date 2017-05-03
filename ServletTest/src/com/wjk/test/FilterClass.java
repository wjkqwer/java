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
		// ��ȡ��ʼ������
		contentType = config.getInitParameter("contentType");

		// �����ʼ������
		System.out.println("����: " + contentType);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter");
		
		//��:����������ContentType��Ȼ��Ѵ˹���������Ϊ��������Servlet���Ͳ�����ÿ��Servlet�ж�дͬ���Ĵ���
		response.setContentType(contentType);

		// ��������й��˴�����ɺ��ڰ����󴫻ع�����
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
