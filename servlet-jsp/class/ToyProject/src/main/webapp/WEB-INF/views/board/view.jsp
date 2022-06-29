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
			 
			 <table class="table table-bordered vertical">
			 	<tr>
		 			<th>번호</th>
		 			<td>${dto.seq}</td>
		 		</tr>
		 		<tr>
		 			<th>이름</th>
		 			<td>${dto.name}(${dto.id})</td>
		 		</tr>
		 		<tr>
		 			<th>날짜</th>
		 			<td>${dto.regdate}</td>
		 		</tr>
		 		<tr>
		 			<th>조회수</th>
		 			<td>${dto.readcount}</td>
		 		</tr>
		 		<tr>
		 			<th>제목</th>
		 			<td>${dto.subject}</td>
		 		</tr>
		 		<tr>
		 			<th>내용</th>
		 			<td style="height: 300px; vertical-align: middle;">${dto.content}</td>
		 		</tr>
		 		
		 	</table>
			 	
		 	<div class="btns">
		 		<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/board/list.do?column=${column}&word=${word}'" />
		 		<c:if test="${not empty auth}">
		 		
		 		<c:if test="${auth == dto.id || auth == 'admin'}">
		 		<button class="btn btn-primary" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}'">
		 			수정하기
		 		</button>
		 		<button class="btn btn-danger" onclick="location.href='/toy/board/del.do?seq=${dto.seq}'">
		 			삭제하기
		 		</button>
		 		</c:if>
		 		<button class="btn btn-success" onclick="location.href='/toy/board/edit.do?seq'">
		 			답변작성
		 		</button>
		 		</c:if>
		 	</div>
		 	
		 	<form method="POST" action="/toy/board/addcommentok.do">
		 		<table id="commentForm">
		 			<tr>
		 				<td>
		 					<textarea class="form-control" name="content" required></textarea>
		 				</td>
		 				<td>
		 					<button class="btn btn-primary">댓글 쓰기</button>
		 				</td>
		 			</tr>
		 		</table>
		 		<input type="hidden" name="pseq" value="${dto.seq}">
		 		<input type="hidden" name="isSearch" value="${isSearch}" />
		 		<input type="hidden" name="column" value="${column}" />
		 		<input type="hidden" name="word" value="${word}" />
		 	</form>
		 	
		 	<table class="table table-bordered" id="commentList">
		 	
		 		<c:forEach var="cdto" items="${clist}">
		 		<tr>
		 			<td>
		 				<div>${cdto.content}</div>
		 				<div>
		 					<span>${cdto.regdate}</span>
		 					<span>${cdto.name}(${cdto.id})</span>
		 				</div>
		 			</td>
		 		</tr>
		 		</c:forEach>
		 	</table>
			 
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>