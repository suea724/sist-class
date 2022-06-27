package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSP 호출
		// resp.sendRedirect("/jsp/mvc/hello.jsp"); > 사용하지 않음
		
		// 사용 중이던 request, response를 다음 페이지에 전달 가능
		// pageContext.forward();
		
		// 데이터 JSP로 넘기기
		String name = "홍길동";
		req.setAttribute("name", name);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp);
	}
}
