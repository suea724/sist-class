<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<%@ include file="/WEB-INF/views/memo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<main>
		<%@ include file="/WEB-INF/views/memo/inc/header.jsp" %>
		<section>
			내용
		</section>
	</main>
	<script>
		<c:if test="${result == 1}">
			location.href = '/jsp/memo/list.do';
		</c:if>
		
		<c:if test="${result == 0}">
			alert('쓰기 실패');
			history.back();
		</c:if>
	</script>
</body>
</html>

