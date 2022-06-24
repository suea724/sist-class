<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
	conn = DBUtil.open();
	
	String sql = "insert into tblTodo values(seqTodo.nextVal, ?, default, ?, default)";
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, request.getParameter("todo"));
	pstmt.setString(2, request.getParameter("priority"));
	
	result = pstmt.executeUpdate();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<script>
	
		<% if (result > 0) { %>
			alert('추가 성공!');
			location.href = 'list.jsp';
		<% } else { %>
			alert('추가 실패!');
			location.href = 'add.jsp';
		<% } %>
		
	</script>

</body>
</html>
















