<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p {
		color: cornflowerblue;
	}
</style>
</head>
<body>
	<h1>JSP 페이지</h1>
	<p>문단입니다.</p>
	
	<%
		// 자바 영역
		Calendar now = Calendar.getInstance();
	%>
	
	<p>현재 날짜 : <%= String.format("%tF", now) %></p>
	<%@ include file="inc/copyright.jsp" %>
</body>
</html>