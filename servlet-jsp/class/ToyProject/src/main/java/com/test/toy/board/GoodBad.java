package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/goodbad.do")
public class GoodBad extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 데이터 가져오기
		 * 2. DB 작업 > DAO 위임
		 * 3. 결과에 따라 피드백
		 */
		
		// 1.
		HttpSession session = req.getSession();
		
		String seq = req.getParameter("seq");
		String isSearch = req.getParameter("isSearch");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String good = req.getParameter("good");
		String bad = req.getParameter("bad");
		
		// 2.
		BoardDAO dao = new BoardDAO();
		
		GoodBadDTO dto = new GoodBadDTO();
		
		dto.setGood(good);
		dto.setBad(bad);
		dto.setId((String)session.getAttribute("auth"));
		dto.setBseq(seq);
		
		// 3.
		int result = dao.updateGoodbad(dto);
		
		if (result == 1) {
			resp.sendRedirect(String.format("/toy/board/view.do?seq=%s&isSearch=%s&column=%s&word=%s", seq, isSearch, column, URLEncoder.encode(word, "UTF-8")));
		} else {
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<script>");
			writer.println("alert('failed');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();
		}

	}
}

