package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스 선언
public class Ex02 extends HttpServlet {
	
	// 2. doGet/doPost 메서드 선언
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setCharacterEncoding("UTF-8");
		
		// 3. 동적 HTML 페이지 작성 구현
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>서블릿</h1>");
		writer.println("<p>동적 웹 페이지입니다.</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
		
		// http://localhost:9090/ServletTest/servlet/com.test.servlet.Ex02
		// http://localhost:9090/ServletTest/aaa
	}

}
