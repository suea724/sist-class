<%@page import="com.test.jsp.DBUtil"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
	String path = application.getRealPath("/gallery/images");
	int size = 1024 * 1024 * 100;
	MultipartRequest multi = new MultipartRequest(
											request, // 원래 request 객체
											path, 	// 업로드 위치
											size,	// 최대 크기
											"UTF-8", // 인코딩 지정
											new DefaultFileRenamePolicy()); 
	
	conn = DBUtil.open();
	
	String sql = "insert into tblGallery values(seqGallery.nextval, ?, ?, default)";
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, multi.getOriginalFileName("attach"));
	pstmt.setString(2, multi.getParameter("subject"));
	
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
		alert("추가 성공");
		location.href = 'list.jsp';
	<% } else { %>
		alert('추가 실패');
		location.href = 'add.jsp';
	<% } %>
</script>
</html>