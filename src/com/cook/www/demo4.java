package com.cook.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取表单数据
		String name = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String parameter = request.getParameter("checked");
		Cookie ck = new Cookie(name+" ",parameter);
		ck.setPath("/demo3");
		//处理业务逻辑(1.如登陆,转账,等一系列操作)
		if ("tom".equals(name)&&"123".equals(pwd)) { 
			if (parameter!=null) {
				ck.setMaxAge(Integer.MAX_VALUE);//永久保存cookie
			}else{
				ck.setMaxAge(0);
			}
			response.addCookie(ck);
			out.write("登陆成功!");
		}else{
			out.print("登陆失败!");
			//设置2秒钟跳转登陆等页面
			response.setHeader("refresh","2;url="+request.getContextPath()+"/demo3");
		}
		//分发转向
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
