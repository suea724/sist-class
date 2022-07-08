package com.test.toy.etc;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/etc/openapi02.do")
public class OpenAPI02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String page = req.getParameter("page");
		
		int currentPage = 1;
		
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		currentPage = (currentPage - 1) * 10 + 1;
		
		String query = req.getParameter("query");
		
		// System.out.println(query);
		
		OpenAPIDAO dao = new OpenAPIDAO();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		map.put("currentPage", currentPage + "");
		
		if (query != null) {
			ResultDTO rdto = dao.search(map);
			rdto.setQuery(map.get("query"));
			req.setAttribute("rdto", rdto);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/etc/openapi02.jsp");
		dispatcher.forward(req, resp);
	}
}
