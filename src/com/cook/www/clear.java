package com.cook.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class clear extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("lastAccessTime","");
		cookie.setPath(request.getContextPath());//���ñ�ɾ��cookie��path,������ܻ�ɾ������
		cookie.setMaxAge(0);//ɾ��cookie
		response.addCookie(cookie);//����յ�cookieд��ͻ���
		PrintWriter out = response.getWriter();
		out.print("<a href ='demo1'>����</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
