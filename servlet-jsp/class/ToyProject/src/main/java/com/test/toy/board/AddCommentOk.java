package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/addcommentok.do")
public class AddCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 인코딩
		 * 2. 데이터 가져오기
		 * 3. DB 작업 > DAO
		 * 4. 피드백 
		 */
		
		HttpSession session = req.getSession();
		
		// 1.
		req.setCharacterEncoding("UTF-8");
		
		// 2.
		String content = req.getParameter("content");
		String pseq = req.getParameter("pseq");
		
		String isSearch = req.getParameter("pseq");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		// 3.
		CommentDTO dto = new CommentDTO();
		
		dto.setId((String)session.getAttribute("auth"));
		dto.setContent(content);
		dto.setPseq(pseq);
		
		BoardDAO dao = new BoardDAO();
		
		int result = dao.addComment(dto);
		
		req.setAttribute("result", result);
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		req.setAttribute("pseq", pseq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/addcommentok.jsp");
		dispatcher.forward(req, resp);
	}

}
