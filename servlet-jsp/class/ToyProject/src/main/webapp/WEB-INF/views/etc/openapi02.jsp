<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	form {
		display: flex;
	}
	
	form input[name=query] {
		width: 300px;
		margin-right: 5px;
	}
	
	.table th, .table td {
		text-align: center;
	}
	
	.table th, .table td {text-align: center;}
	.table th:nth-child(1) {width: 120px;}
	.table th:nth-child(2) {width: auto;}
	.table th:nth-child(3) {width: 120px;}
	.table th:nth-child(4) {width: 100px;}
	.table th:nth-child(5) {width: 120px;}
	.table th:nth-child(6) {width: 120px;}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>Naver Books</h2>
			 
			 <form method="GET" action="/toy/etc/openapi02.do">
				 <div class="well well-sm">
				 	<c:if test="${rdto.query == null}">
			 		<input type="text" name="query" class="form-control" placeholder="검색어를 입력하세요.">
			 		</c:if>
			 		<c:if test="${rdto.query != null}">
			 		<input type="text" name="query" class="form-control" value="${rdto.query}">
			 		</c:if>
			 		<input type="submit" value="검색하기" class="btn btn-primary">
				 </div>
			 </form>
			 
			 <hr>
			 
			 <table class="table table-bordered">
			 	<tr>
			 		<th>표지</th>
			 		<th>제목</th>
			 		<th>저자</th>
			 		<th>가격</th>
			 		<th>출판사</th>
			 		<th>출간일</th>
			 	</tr>
			 	<c:forEach var="dto" items="${rdto.list}">
			 	<tr>
			 		<td><img src="${dto.image}"></td>
			 		<td><a href="${dto.link}" target="_blank">${dto.title}</a></td>
			 		<td>${dto.author}</td>
			 		<td>
			 			<div>${dto.discount}원</div>
			 			<div style="text-decoration: line-through">${dto.price}</div>
		 			</td>
			 		<td>${dto.publisher}</td>
			 		<td>${dto.pubdate}</td>
			 	</tr>
			 	</c:forEach>
			 	<c:if test="${empty rdto.list}">
			 	<tr>
			 		<td colspan="6">검색 결과가 없습니다.</td>
			 	</tr>
			 	</c:if>
			 </table>
			 
			 <hr>
			 
			 <c:forEach var="i" begin="1" end="${rdto.total / 10 + 1}">
		 		<a href="/toy/etc/openapi02.do?page=${i}&query=${rdto.query}">${i}</a>
			 </c:forEach>
			 
		</section>
	</main>
	
	<script>
	</script>

</body>
</html>