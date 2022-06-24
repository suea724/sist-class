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
	
	int result = 0;
	
	try {
		// 3.
		DBUtil util = new DBUtil();
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstmt = null;
		
		conn = util.open();
		
		System.out.println(conn.isClosed()); // false
		
		String sql = "insert into tblAddress(seq, name, age, address, gender, tel) values (seqAddress.nextVal, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.setString(3, address);
		pstmt.setString(4, gender);
		pstmt.setString(5, tel);
		
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
		
		alert('추가 실패');
		history.back();
		
		<% } %> 
	</script>

</body>
</html>
















