<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*
		1. 인코딩 처리
		2. 데이터 가져오기
		3. DB 작업
			3.1 DB 연결
			3.2 SQL
			3.3 종료
		4. 마무리
	*/
	
	// 1.
	request.setCharacterEncoding("UTF-8");

	// 2.
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	String seq = request.getParameter("seq");
	
	int result = 0;
	
	try {
		// 3.
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtil.open();
		
		System.out.println(conn.isClosed()); // false
		
		String sql = "update tblAddress set name = ?, age = ?, address = ?, gender = ?, tel = ? where seq = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setString(3, address);
		pstmt.setString(4, gender);
		pstmt.setString(5, tel);
		pstmt.setString(6, seq);
		
		result = pstmt.executeUpdate();
		
		// 4.
		if (result > 0) {
			// 추가 성공
		} else {
			// 추가 실패
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<!--  -->
	<main>
		<header>
			<%@ include file="inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				<% if (result > 0) { %>
					<div>추가 성공!</div>
					<a href="list.jsp">목록 보기</a>
				<% } else {  %>
					<div>추가 실패</div>
					<a href="#!" onclick="history.back();">돌아가기</a>
				<% } %>
			</div>
		</section>
	</main>
	
	<script>
		<%-- 
		<% if (result > 0) { %>
			alter('추가 성공');
			location.href = 'list.jsp';
		<% } else { %>
			alert('추가 실패');
			history.back();
		<% } %> --%>
		
		<% if (result > 0) { %>
		
		location.href = 'list.jsp';
		
		<% } else { %>
		
		alert('수정 실패');
		history.back();
		
		<% } %>
	</script>

</body>
</html>
















