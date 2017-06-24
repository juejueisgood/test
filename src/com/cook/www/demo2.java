package com.cook.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//�õ���Ӧ������
		PrintWriter out = response.getWriter();
		//��ȡCookie���û����һ�η���ʱ��
		Cookie[] cookies = request.getCookies();//��ȡ�ͻ�������Cookie������������
		//�жϵ�ǰcookies�е�name�Ƿ�����Ҫ��cookies
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			//�������Ҫ��cookies
			if ("lastAccessTime".equals(cookies[i].getName())) {
				//���cookies�е�valueȡ��
				Long l = Long.parseLong(cookies[i].getValue());
				//yyyy-MM-dd
				out.write("���һ�ε�½ʱ��Ϊ��"+ new Date(l).toLocaleString()); 
			}	
		} 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}