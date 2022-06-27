package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * 1. 인코딩
		 * 2. 데이터 가져오기
		 * 3. DB 작업
		 * 4. int result
		 * 5. JSP 호출 + result 전달
		 */
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		
		// 3.
		DTO dto = new DTO();
		
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setName(name);
		dto.setPw(pw);
		
		DAO dao = new DAO();
		
		int result = 0;
		
		// 암호 일치하는 지 체크
		if (dao.check(dto)) {
			result = dao.edit(dto);
		} else {
			result = 0;
		}
		
		// 4.
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/memo/editok.jsp");
		dispatcher.forward(req, resp);
	}

}