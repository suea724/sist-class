<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/* 
		페이지 간 이동
		1. HTML : <a href="">

		2. JavaScript : location.href=""; > 클라이언트 제어
		
		3. Servlet/JSP : response.sendRedirect(""); > 서버측 제어		
	*/
	
	response.sendRedirect("ex12_response_2.jsp");

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
		<h1>1번 페이지</h1>
	</div>
	
	<script>
	
	</script>

</body>
</html>