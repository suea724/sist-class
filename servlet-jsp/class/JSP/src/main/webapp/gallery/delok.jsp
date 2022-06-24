<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
	conn = DBUtil.open();
	
	String sql = "delete from tblGallery where seq = ?";
	pstmt = conn.prepareStatement(sql);

	pstmt.setString(1, request.getParameter("seq"));
	
	result = pstmt.executeUpdate();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
</head>
<body>

	<!-- list.jsp -->
	<div class="container">
	</div>
	
</body>

<script>
	<% if (result > 0) { %>
		alert("삭제 성공");
		location.href = 'list.jsp';
	<% } else { %>
		alert('삭제 실패');
		location.href = 'add.jsp';
	<% } %>
</script>
</html>