package com.cook.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo1 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		/**
		  Cookieʵ�����������������
		  Cookie cookie = new Cookie(String name,String value);
		 */
		//�õ����һ�η���ʱ�䱣�浽�ͻ���
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");	
		response.addCookie(cookie);
		cookie.setMaxAge(60*5);//����cookie��Чʱ��,ʱ����5����
		cookie.setPath("/");//����cookie��Ч·��,��ʾ�ڵ�����������Ŀ��Ч
		cookie.setPath(request.getContextPath());//����ǰӦ��
		cookie.setPath("/day10_Servlet");
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
		out.print("<a href ='clear'>clear</a>");
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}
}
