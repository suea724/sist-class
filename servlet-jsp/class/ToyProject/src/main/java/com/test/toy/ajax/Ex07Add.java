package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07add.do")
public class Ex07Add extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		
		System.out.println(name);
		
		AjaxDAO dao = new AjaxDAO();
		
		dao.addAddress(name, age, gender, tel, address);
		ArrayList<AddressDTO> list = dao.listAddress();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("[");
		
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
		
		/**
		 * "seq" : "%s",
		 * "name" : "%s",
		 * "age" : "%s",
		 * "address" : "%s",
		 * "gender" : "%s",
		 * "tel" : "%s"
		 */
		
		
		writer.close();
	}
}
