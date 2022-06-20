<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>페이지 지시자</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
	Corporis autem accusamus doloribus modi eveniet quae dolores vero. Illo nemo aliquam!</p>
	<%
		// Random rnd = null;
		// System.out.println(rnd.nextInt()); // NPE
	%>
	
	<!-- 재사용 -->
	<%@ include file="inc/copyright.jsp" %>
</body>
</html>