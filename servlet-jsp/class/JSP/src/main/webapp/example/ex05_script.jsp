<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
	int age = 20;
	String color = "cornflowerblue";
	String txt = "<input type='text'>";
	String title = "<h2>제목입니다.</h2>";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		표현식의 용도
		- 자바의 값을 HTML 소스에 출력한다.
		1. 동적으로 PCDATA로 사용한다.
		2. CSS의 일부로 사용한다.
		3. JS의 일부로 사용한다.
		
	 -->
	<h1>회원 정보</h1>
	
	<div>이름: <%= name %></div>
	<div>나이: <%= age %></div>
	<div style="color:<%= color %>">색상: <%= color %></div>
	<div><%= txt %></div>
	
	<script>
		alert('<%= name %>');
	</script>
</body>
</html>