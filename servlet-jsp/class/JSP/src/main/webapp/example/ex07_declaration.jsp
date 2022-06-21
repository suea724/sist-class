<%@page import="com.test.jsp.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	// 선언부 : 클래스 영역 > 자주 사용하지는 않음
	int b = 20; // 클래스 멤버 변수
	
	public int sum(int a, int b) {
		return a + b;
	}
%>

<%
	//스크립틀릿 : 메서드 영역

	// 변수 종류? 클래스 멤버 변수 or 지역 변수
	int a = 10; // 메서드 지역 변수
	
	// 클래스를 import해서 메서드를 사용하는 경우가 많음!
	Util util = new Util();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선언부</h1>
	<div>sum(10, 20) = <%= sum(10, 20) %> </div>
</body>
</html>