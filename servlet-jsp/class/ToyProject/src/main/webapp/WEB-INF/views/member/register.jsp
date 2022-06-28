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
			  <form method="POST" action="/toy/member/registerok.do" enctype="multipart/form-data">
			 	<table class="table table-bordered vertical">
			 		<tr>
			 			<th>아이디</th>
			 			<td><input type="text" name="id" class="form-control short" required /></td>
			 		</tr>
			 		<tr>
			 			<th>비밀번호</th>
			 			<td><input type="password" name="pw" class="form-control short" required /></td>
			 		</tr>
			 		<tr>
			 			<th>이름</th>
			 			<td><input type="text" name="name" class="form-control short" required /></td>
			 		</tr>
			 		<tr>
			 			<th>사진</th>
			 			<td><input type="file" name="pic" class="form-control" /></td>
			 		</tr>
			 	</table>
			 	
			 	<div class="btns">
			 		<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location='/toy/index.do'" />
			 		<input type="submit" value="회원 가입" class="btn btn-primary" />
			 	</div>
			 </form>
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>