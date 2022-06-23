<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 내장 객체 생명 주기 + 페이지 이동 시 데이터 전달하기
	
	// 1. 지역 변수
	int a = 10; // 이 페이지 내에서만 유효

	// 3. pageContext 객체 사용
	pageContext.setAttribute("c", 30);
	
	// 4. request 객체
	request.setAttribute("d", 40);
	
	// 5. session 객체
	session.setAttribute("e", 50);
	
	// 6. application 객체
	application.setAttribute("f", 60);
	
	// response.sendRedirect("ex20_scope_2.jsp");
	pageContext.forward("ex20_scope_2.jsp");
	
	/*
		생명주기(짧은순)
		pageContext < request < session < application
		   (한페이지)  (한페이지~)  (접속중)  (사이트 동작 중)
		
	
	
	*/

%>

<%!
	// 2. 멤버 변수
	int b = 20; // 이 페이지 내에서만 유효
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<div class="container">
		<h1>첫번째 페이지</h1>
		<a href="ex20_scope_2.jsp">두번째 페이지로 이동</a>
	</div>
	
	<script>
	
	</script>

</body>
</html>