package com.test.toy.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/unregisterok.do")
public class UnregisterOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * 1. 탈퇴 회원 아이디
		 * 2. DB 작업 > DAO 위임
		 * 3. 결과를 JSP에 반환 + 로그아웃
		 */
		
		// 1.
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("auth");
		
		// 2.
		MemberDAO dao = new MemberDAO();
		
		// 프로필 사진 삭제
		MemberDTO dto = dao.get(id);
		
		if (!dto.getPic().equals("pic.png")) {
			String path = req.getRealPath("/pic");
			path += "/" + dto.getPic();
			
			File file = new File(path);
			file.delete();
		}
		
		int result = dao.unregister(id);
		
		// 3.
		if (result == 1) {
			session.invalidate();
		}
		
		req.setAttribute("dao", dao);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/unregisterok.jsp");
		dispatcher.forward(req, resp);
	}

}