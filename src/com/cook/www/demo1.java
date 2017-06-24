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
		  Cookie实例化会带有两个参数
		  Cookie cookie = new Cookie(String name,String value);
		 */
		//得到最后一次访问时间保存到客户端
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");	
		response.addCookie(cookie);
		cookie.setMaxAge(60*5);//设置cookie有效时间,时间是5分钟
		cookie.setPath("/");//设置cookie有效路径,表示在当服务器下项目有效
		cookie.setPath(request.getContextPath());//代表当前应用
		cookie.setPath("/day10_Servlet");
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
		out.print("<a href ='clear'>clear</a>");
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}
}
