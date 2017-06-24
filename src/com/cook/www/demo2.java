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
		//得到响应输入流
		PrintWriter out = response.getWriter();
		//获取Cookie中用户最后一次访问时间
		Cookie[] cookies = request.getCookies();//获取客户端所有Cookie保存在数组中
		//判断当前cookies中的name是否是想要的cookies
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			//如果是想要的cookies
			if ("lastAccessTime".equals(cookies[i].getName())) {
				//则吧cookies中的value取出
				Long l = Long.parseLong(cookies[i].getValue());
				//yyyy-MM-dd
				out.write("最后一次登陆时间为："+ new Date(l).toLocaleString()); 
			}	
		} 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}