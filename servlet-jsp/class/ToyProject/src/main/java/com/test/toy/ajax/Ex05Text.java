package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.board.BoardDAO;
import com.test.toy.board.BoardDTO;

@WebServlet("/ajax/ex05text.do")
public class Ex05Text extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get("341");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("begin", "1");
		map.put("end", "3");
		map.put("isSearch", "n");
		ArrayList<BoardDTO> list = dao.list(map);
		
		
		// Text 반환
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		PrintWriter writer = resp.getWriter();
		// writer.print(dto.getName());
		
		// 단일 데이터 CSV
		// writer.printf("%s,%s,%s,%s", dto.getSubject(), dto.getContent(), dto.getName(), dto.getRegdate());
		
		// 다중 데이터 CSV
		for (BoardDTO item : list) {
			writer.printf("%s,%s,%s\r\n", item.getSubject(), item.getName(), item.getRegdate());
		}
		
		writer.close();
	}
}

