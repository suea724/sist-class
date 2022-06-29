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
			 <h2>Board</h2>
			 
			 <form method="POST" action='/toy/board/addok.do'>
				 <table class="table table-bordered vertical">
				 		<tr>
				 			<th>제목</th>
				 			<td><input type="text" name="subject" class="form-control" required /></td>
				 		</tr>
				 		<tr>
				 			<th>내용</th>
				 			<td><textarea name="content" class="form-control"></textarea></td>
				 		</tr>
				 	</table>
				 	
				 	<div class="btns">
				 		<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/index.do'" />
				 		<input type="submit" value="글쓰기" class="btn btn-primary" />
				 	</div>
 			 </form>
			 
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>