package com.test.toy.board;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * 1. 데이터 가져오기
		 * 2. DB 작업 > DAO 위임
		 * 3. 결과 JSP에 반환
		 */
		
		HttpSession session = req.getSession();
		
		// 1.
		String seq = req.getParameter("seq");
		
		// 검색 정보
		String isSearch = req.getParameter("isSearch");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		// 2.
		BoardDAO dao = new BoardDAO();

		// 2.1 조회수 증가
		if (session.getAttribute("read") == null || session.getAttribute("read").toString().equals("n")) {
			dao.updateReadCount(seq);
			session.setAttribute("read", "y");
		}
		
		BoardDTO dto = dao.get(seq);
		
		// 2.2
		
		// 태그 비활성화		
		dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
		dto.setContent(dto.getContent().replace("<", "&lt;").replace(">", "&gt;"));
		
		// 개행 처리
		dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
		// 검색어 CSS 조작
		if (isSearch != null && column != null && isSearch.equals("y") && column.equals("content")) {
			dto.setContent(dto.getContent().replace(word, "<span style=\"background-color: gold;\">" + word + "</span>"));
		}
		
		// 첨부파일이 이미지이면 내용과 함께 출력
		
		if (dto.getFilename() != null
				&& (dto.getFilename().toLowerCase().endsWith(".jpg")
					|| dto.getFilename().toLowerCase().endsWith(".jpeg")
					|| dto.getFilename().toLowerCase().endsWith(".gif")
					|| dto.getFilename().toLowerCase().endsWith(".png"))) {
			
			// 이미지 정보 획득
			BufferedImage img = ImageIO.read(new File(req.getRealPath("files") + "\\" + dto.getFilename()));
			
			dto.setContent(dto.getContent() + String.format("<div style='margin-top: 15px;'><img src='/toy/files/%s' style='max-width:650px;' >", dto.getFilename()));
		}
		
		
		
		// 2.3. 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq);
		
		for (CommentDTO cdto : clist) {
			cdto.setContent(cdto.getContent().replace("\r\n", "<br>"));
		}
		
		// 3.
		req.setAttribute("dto", dto);
		
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		
		req.setAttribute("clist", clist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
		dispatcher.forward(req, resp);
	}

}
