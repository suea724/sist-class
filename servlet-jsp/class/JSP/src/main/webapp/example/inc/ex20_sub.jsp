<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1>조각 페이지</h1>
	
	조각 페이지 영역
	
	<%-- <p>1. 지역 변수 a : <%= a %></p>
	<p>2. 멤버 변수 b : <%= b %></p> --%>
	<p>3. pageContext 객체 c : <%= pageContext.getAttribute("c") %></p>
	<p>4. request 객체 d : <%= request.getAttribute("d") %></p>
	<p>5. session 객체 e : <%= session.getAttribute("e") %></p>
</div>