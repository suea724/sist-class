<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>addok.jsp</h1>
	
	<h2>단일 데이터</h2>
	<div>num : ${num}</div>
	
	<h2>다중 데이터</h2>
	<div>이름: ${name}</div>
	<div>나이: ${age}</div>
	<div>주소: ${address} </div>
	
	<h2>다중 데이터</h2>
	
	<c:forEach var="seq" items="${cb}">
		<div>${seq}</div>
	</c:forEach>
		
</body>
</html>