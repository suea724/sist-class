package com.test.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

public class Ex01 {
	
	// 브라우저 요청이 들어오면, 자바 프로그램이 HTML, CSS, JavaScript를 사용해서 페이지를 제작
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		String html = "";

		html += "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8'>";
		html += "</head>";
		html += "<body>";
		html += "<h1>동적 웹페이지</h1>";
		html += "<hr>";
		html += String.format("현재 날짜: %tF", now);
		html += "</body>";
		html += "</html>";
		
		System.out.println(html);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\main\\webapp\\ex01.html"));
			writer.write(html);
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
