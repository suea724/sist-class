<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		 1. 데이터 가져오기
		 2. DB 작업 > select
		 3.1 있으면 > 인증티켓 발급
		 3.2 없으면 > X
		 4. 피드백
	*/
	
	// 1.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 2.
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	conn = DBUtil.open();
	
	// 로그인 처리 SQL
	String sql = "select * from tblUser where id = ? and pw = ?"; // 최대 레코드 수 1개
	
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	
	rs = pstmt.executeQuery();
	
	if (rs.next()) {
		// 로그인 성공
		
		// 인증 티켓 발급 > 세션
		session.setAttribute("auth", id); // 식별하기 위한 값으로 아이디를 넣는 것이 좋음
		session.setAttribute("name", rs.getString("name")); // 계정 정보 > DB 조회 필요X
		session.setAttribute("lv", rs.getInt("lv")); // 계정 정보
		
	} else {
		// 로그인 실패
	}

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
		
	</div>
	
	<script>
		<% if (session.getAttribute("auth") != null ) { %>
		location.href = 'index.jsp';
		<% } %>
		
		<% if (session.getAttribute("auth") == null ) { %>
		alert('로그인 실패');
		history.back();
		<% } %>
		
	</script>

</body>
</html>