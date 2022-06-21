<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");

	// 텍스트 박스
	// 입력값 없으면 빈문자열("") 반환
	String txt1 = request.getParameter("txt1");
	
	// 암호 박스
	String pw1 = request.getParameter("pw1");
	
	// 다중 텍스트
	String txt2 = request.getParameter("txt2");
	txt2 = txt2.replace("\n", "<br>");
	
	// 체크 박스
	// value O > 체크 시 value값 반환, 안했을 때 null 반환
	// value X > 체크 시 "on" 반환, 안했을 때 null 반환
	String cb1 = request.getParameter("cb1");
	String cb2 = request.getParameter("cb2");
	
	// 체크 박스 여러개
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	String cb5 = request.getParameter("cb5");
	
	String temp = cb3 + ", " + cb4 + ", " + cb5;
	
	temp = "";
	for (int i = 6 ; i <= 8 ; i ++) {
		temp += request.getParameter("cb" + i) + ", ";
	}
	
	// 같은 name의 값을 여러개 가져올 때 > String[] getParameterValues()
	String[] cbs = request.getParameterValues("cb9");
	
	// 라디오 버튼
	String rb = request.getParameter("rb");
	
	// 셀렉트 박스
	String sel1 = request.getParameter("sel1");
	
	String[] sels = request.getParameterValues("sel2");
	
	// 히든 태그
	String id = request.getParameter("id");
	
	// 컬러피커
	String color = request.getParameter("color");
	
	// 좌표
	String left = request.getParameter("left");
	String top = request.getParameter("top");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color: <%= color %>;
	}
</style>
</head>
<body>
	<h1>결과</h1>
	<h3>텍스트 박스</h3>
	<div><%= txt1 %></div>

	<br>
	
	<h3>암호 박스</h3>
	<div><%= pw1 %></div>
	
	<br>
	
	<h3>다중 라인 텍스트 박스</h3>
	<div><%= txt2 %></div>
	
	<br>
	
	<h3>체크 박스</h3>
	<div><%= cb1 %> <%= cb2 %></div>
	
	<br>
	
	<h3>체크 박스 여러개</h3>
	<div><%= temp %></div>
	
	<br>
	
	<div><%= Arrays.toString(cbs) %></div>
	
	<br>
	
	<div><%= rb %></div>
	
	<br>
	
	<div><%= sel1 %></div>
	
	<br>
	
	<div><%= Arrays.toString(sels) %></div>
	
	<br>
	
	<div><%= id %></div>
	
	<br>
	
	<div><%= color %></div>
	
	<br>
	
	<h3>좌표</h3>
	<div><%= left %>, <%= top %></div>
	
</body>
</html>