<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%



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
		<h1>JSTL</h1>
		
		<p>JSTL은 자바 프로그래밍 기능의 일부를 태그 형식으로 표현해서 지원하는 기술이다.</p>
	
		<h2>변수 선언</h2>
		<%
			int a = 10; // 지역 변수
			pageContext.setAttribute("b", 20); // 내장 객체 변수
		%>
		
		<c:set var="c" value="30" /> <!-- JSTL 변수 선언 = pageContext.setAttribute("c", 30)과 동일 -->
		
		<div>a: <%= a %></div>
		<div>a: ${a}</div>
		
		<div>b: <%= pageContext.getAttribute("b") %></div>
		<div>b: ${b}</div>
		
		<div>c: <%= pageContext.getAttribute("c") %></div>
		<div>c: ${c}</div>
		
		<h2>변수 수정하기</h2>
		
		<c:set var="c" value="100" />
		<div>c: ${c}</div>
		
		<h2>변수 삭제하기(컬렉션의 요소 삭제)</h2>
		<div>${empty c}</div>
		
		<c:remove var="c" />
		<div>c: ${c}</div>
		<div>${empty c}</div>
		
		<h2>조건문</h2>
		<c:set var="num" value="10" />
		<div>num : ${num}</div>
		
		<c:if test="${num > 0}">
			<div>${num}은 양수입니다.</div>
		</c:if>
		
		<c:if test="${num <= 0}">
			<div>${num}은 양수가 아닙니다.</div>
		</c:if>
		
		<c:set var="a" value="10" />
		<c:set var="b" value="5" />
		
		
		<c:if test="${Integer.parseInt(a) > Integer.parseInt(b)}">
			<div>aaa</div>
		</c:if>
		
		<hr>
		
		<c:choose>
			<c:when test="${num > 0}">양수</c:when>
			<c:when test="${num < 0}">음수</c:when>
			<c:otherwise>영</c:otherwise>
		</c:choose>
		
		<hr>
		
		<h2>반복문 (일반 for문 + 향상된 for문)</h2>
		
		<c:forEach var="i" begin="0" end="9" step="1">
			<div>아이템 ${i}</div>
		</c:forEach>
		
		<%
			String[] names = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
			pageContext.setAttribute("names", names);
		%>
		
		<ol>
			<c:forEach var="name" items="${names}">
				<li>${name}</li>
			</c:forEach>
		</ol>
		
	
	</div>
	
	<script>
	
	</script>

</body>
</html>