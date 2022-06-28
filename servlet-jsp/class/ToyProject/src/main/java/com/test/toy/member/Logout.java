package com.test.toy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 로그아웃
		 * 2. JSP 호출
		 */
		
		// 1.
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		//2.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/logout.jsp");
		dispatcher.forward(req, resp);
	}

}
