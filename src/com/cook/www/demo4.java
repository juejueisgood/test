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
		//��ȡ������
		String name = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String parameter = request.getParameter("checked");
		Cookie ck = new Cookie(name+" ",parameter);
		ck.setPath("/demo3");
		//����ҵ���߼�(1.���½,ת��,��һϵ�в���)
		if ("tom".equals(name)&&"123".equals(pwd)) { 
			if (parameter!=null) {
				ck.setMaxAge(Integer.MAX_VALUE);//���ñ���cookie
			}else{
				ck.setMaxAge(0);
			}
			response.addCookie(ck);
			out.write("��½�ɹ�!");
		}else{
			out.print("��½ʧ��!");
			//����2������ת��½��ҳ��
			response.setHeader("refresh","2;url="+request.getContextPath()+"/demo3");
		}
		//�ַ�ת��
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
