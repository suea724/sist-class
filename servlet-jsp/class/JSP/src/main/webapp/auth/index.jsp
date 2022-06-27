<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/auth/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<div class="container">
		<h1>인증(Authentication), 인가(Authorization)</h1>
		
		<% if (session.getAttribute("auth") == null) { %>
		<fieldset>
			<input type="button" value="로그인" class="btn btn-primary" onclick="location.href='login.jsp'">
		</fieldset>
		<% } %>
		
		<% if ((session.getAttribute("auth") != null)) { %>
		<fieldset>
			<input type="button" value="로그아웃" class="btn btn-primary" onclick="location.href='logout.jsp'">
			
			<div>
				<!-- 로그인 한 사용자 정보 -->
				<%= session.getAttribute("name") %>(<%= session.getAttribute("auth") %>) <%= session.getAttribute("lv") %>
			</div>
		</fieldset>
		<% } %>
		
		<hr>
		
		<!-- 인증 정보가 존재하고, 준회원 이상 등급이면 회원 전용 페이지 버튼 출력 -->
		<% if (session.getAttribute("auth") != null && (int)session.getAttribute("lv") < 3) { %>
		<a href="member.jsp" class="btn btn-success">회원 전용 페이지</a>
		<% } %>
		
		<hr>
		
		<!-- 세션에 정보가 없거나 준회원일 경우 회원 전용 페이지 접근 불가 -->
		<% if (session.getAttribute("auth") == null || (int)session.getAttribute("lv") == 3) { %>
		<a href="#!" class="btn btn-success" onclick="alert('회원만 접근이 가능합니다.')">회원 전용 페이지</a>
		<% } else {%>
		<a href="member.jsp" class="btn btn-success">회원 전용 페이지</a>
		<% } %>
		
		<hr>
		
		<!-- 세션에 정보가 없거나 관리자가 아닌 경우 관리자 전용 페이지 접근 불가 -->
		<% if (session.getAttribute("auth") == null || (int)session.getAttribute("lv") != 1) { %>
		<a href="#!" class="btn btn-success" onclick="alert('관리자만 접근이 가능합니다.');">관리자 전용 페이지</a>
		<% } else { %>
		<a href="admin.jsp" class="btn btn-success">관리자 전용 페이지</a>
		<%}  %>
	</div>
	
	<script>
	
	</script>

</body>
</html>