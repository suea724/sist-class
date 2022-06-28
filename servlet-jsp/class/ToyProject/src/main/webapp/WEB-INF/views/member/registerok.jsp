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
	<script>
	
		<c:if test="${result == 1}">
			location.href = '/toy/member/login.do';
		</c:if>
		
		<c:if test="${result == 0}">
			alert('회원가입 실패');
			history.back;
		</c:if>
	</script>

</body>
</html>