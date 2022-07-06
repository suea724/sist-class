package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07del.do")
public class Ex07Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.delAddress(seq);
		ArrayList<AddressDTO> list = dao.listAddress();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("{");
		
		writer.printf("\"result\": \"%d\",", result);
		
		writer.print("\"list\" : [");
		
		for (int i = 0 ; i < list.size() ; i ++) {
			writer.print("{");
			writer.printf("\"seq\" : \"%s\",", list.get(i).getSeq());
			writer.printf("\"name\" : \"%s\",", list.get(i).getName());
			writer.printf("\"age\" : \"%s\",", list.get(i).getAge());
			writer.printf("\"address\" : \"%s\",", list.get(i).getAddress());
			writer.printf("\"gender\" : \"%s\",", list.get(i).getGender());
			writer.printf("\"tel\" : \"%s\"", list.get(i).getTel());
			writer.print("}");
			if (i < list.size() - 1 ) {
				writer.print(",");
			}
		}
		writer.print("]");
		
		writer.print("}");
		writer.close();
	}
}
