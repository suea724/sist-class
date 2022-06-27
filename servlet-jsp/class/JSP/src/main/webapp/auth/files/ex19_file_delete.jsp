<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 삭제할 이미지명 가져오기
	String fileName = request.getParameter("filename");

	String path = application.getRealPath("/example/images");

	File img = new File(path + "/" + fileName);
	
	img.delete();
	
	response.sendRedirect("ex19_file_form.jsp");

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
	
	</div>
	
	<script>
	
	</script>

</body>
</html>