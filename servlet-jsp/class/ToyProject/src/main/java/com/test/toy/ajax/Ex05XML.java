package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.board.BoardDAO;
import com.test.toy.board.BoardDTO;

@WebServlet("/ajax/ex05xml.do")
public class Ex05XML extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get("341");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("begin", "1");
		map.put("end", "3");
		map.put("isSearch", "n");
		ArrayList<BoardDTO> list = dao.list(map);
		
		
		// XML 반환
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml"); // MIME
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
		// 단일 데이터
		// writer.printf("<name>%s</name>", dto.getName());
		
		// 다중 데이터
		// writer.printf("<item>");
		// writer.printf("<subject>%s</subject>", dto.getSubject());
		// writer.printf("<content>%s</content>", dto.getContent());
		// writer.printf("<name>%s</name>", dto.getName());
		// writer.printf("<regdate>%s</regdate>", dto.getRegdate());
		// writer.printf("</item>");
		
		// 다중 데이터 > list
		writer.print("<list>");
		
		for (BoardDTO item : list) {
		
			writer.printf("<item>");
			writer.printf("<subject>%s</subject>", item.getSubject());
			writer.printf("<content>%s</content>", item.getContent());
			writer.printf("<name>%s</name>", item.getName());
			writer.printf("<regdate>%s</regdate>", item.getRegdate());
			writer.printf("</item>");
		}
		
		writer.print("</list>");
		
		writer.close();
		
		/**
		 * <?xml version="1.0" encoding="UTF-8"?> : XML 선언문
		 */
	}
}
