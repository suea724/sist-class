<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#pic > img {
		width: 150px;
		height: 150px;
	}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>Info</h2>
			 
			 <div id="pic">
			 	<img src="/toy/pic/${dto.pic}">
			 </div>
			 <ul>
			 	<li>${dto.name} (${dto.id})</li>
		 		<li>Lv.${dto.lv} (${dto.lv == 1 ? "일반회원" : "관리자"})</li>
		 		<li>가입일(${dto.regdate})</li>
			 </ul>
			 
			 <hr>
			 
			 <input type="button" value="회원탈퇴" class="btn btn-danger" onclick="location.href='/toy/member/unregister.do'" />
			 
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>