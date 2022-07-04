package com.test.toy.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 데이터 가져오기 (seq)
		 * 2. DB 작업 > DAO 위임
		 * 3. 결과를 JSP에 반환
		 */
		
		HttpSession session = req.getSession();
		
		// 1.
		String seq = req.getParameter("seq");
		
		// 2.
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
			
			// 해시태그 연결 제거
			dao.delTaggingAll(seq);
			
			// 댓글 삭제
			dao.delcommentAll(seq);
			
			// 첨부파일 삭제
			BoardDTO dto = dao.get(seq);
			
			if (dto.getFilename() != null) {
				String path = req.getRealPath("files") + "\\" + dto.getFilename();
				File file = new File(path);
				
				file.delete();
			}
			
			// 좋아요, 싫어요 삭제
			dao.delGoodBad(seq);
			
			// 글 삭제
			result = dao.del(seq);
			
		}
		
		// 3.
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/delok.jsp");
		dispatcher.forward(req, resp);
	}

}