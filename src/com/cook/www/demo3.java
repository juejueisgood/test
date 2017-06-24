package com.cook.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName="";
		String checked="";
		//得到客户端保存的Cookie数据
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null&& i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				userName =cookies[i].getValue();
				checked ="checked='checked'";
			}
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("<form action='"+request.getContextPath()+"/demo3' method='get' >");
		out.print("用户名:<input type='text' name='userName' value='"+userName+"'><br><br>");
		out.print("密码:<input type='password' name='pwd'><br><br>");
		out.print("记住密码:<input type='checkbox' name='checked'"+checked+"><br><br>");
		out.print("<input type='submit' value='登陆'>");
		out.print("</form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
