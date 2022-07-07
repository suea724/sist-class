<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
		
			<h2>크롤링</h2>
			
			 <span>이름 : ${name}</span>
			 
			 <hr>
			 
			 <h2>크롤링</h2>
			 
			 <div>이름: <span id="name"></span></div>
			 
		</section>
	</main>
	
	<script>
		// 자바스크립트로 값 넣어줌 > 동적 처리 > JSOUP이 읽을 수 없음
		$('#name').text('아무개');
	</script>

</body>
</html>