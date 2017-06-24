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
		cookie.setPath(request.getContextPath());//设置被删除cookie的path,否则可能会删出错误
		cookie.setMaxAge(0);//删除cookie
		response.addCookie(cookie);//将清空的cookie写会客户端
		PrintWriter out = response.getWriter();
		out.print("<a href ='demo1'>返回</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
