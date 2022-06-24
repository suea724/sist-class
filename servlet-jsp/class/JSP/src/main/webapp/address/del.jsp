<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 1. 데이터 가져오기 (?seq=5)
	// 2. delok.jsp?seq=5 전달
	
	String seq = request.getParameter("seq");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<main>
		<header>
			<%@ include file="/address/inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				<div class="btns">
					<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='list.jsp'">
					<input type="button" value="삭제하기" class="btn btn-danger" onclick="location.href='delok.jsp?seq=<%= seq %>'">
				</div>
			</div>
		</section>	
	</main>
	
	<script>
		
	</script>

</body>
</html>
















