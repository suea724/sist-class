package com.test.toy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 인코딩
		 * 2. 데이터 가져오기 (subject, content, seq)
		 * 3. DB 작업 > DAO 위임
		 * 4. 결과 JSP에 반환
		 */
		
		HttpSession session = req.getSession();
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		String seq = req.getParameter("seq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		// 3.
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSeq(seq);
		
		BoardDAO dao = new BoardDAO();
		
		int temp = 0;
		
		if (session.getAttribute("auth") == null) {
			temp = 1; // 익명 사용자
		} else {
			if (session.getAttribute("auth").equals(dao.get(seq).getId())) {
				temp = 2; // 글쓴이 > 수정 권한 O
			} else {
				
				if (session.getAttribute("auth").toString().equals("admin")) {
					temp = 3; // 관리자 > 수정 권한 O
				} else {
					temp = 4; // 타인
				}
			}
		}
		
		
		int result = 0;
		
		if (temp == 2 || temp == 3) {
			result = dao.edit(dto);
		}
		
		// 4.
		req.setAttribute("result", result);
		req.setAttribute("seq", seq); // 되돌아가기 위해 필요한 seq
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/editok.jsp");
		dispatcher.forward(req, resp);
	}

}