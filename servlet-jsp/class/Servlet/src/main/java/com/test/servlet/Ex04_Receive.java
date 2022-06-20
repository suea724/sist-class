package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Receive extends HttpServlet {
	
	//	1. get 요청 > doGet() 호출
	//	2. post 요청 > doPost() 호출
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		// form 데이터 수신
		// <input type='text' name='name'>
		String name = req.getParameter("name");
		
		// <input type='text' name='age'>
		String age = req.getParameter("age");
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<p>이름: " + name +  "</p>");
		writer.println("<p>나이: " + age + "</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}

}
