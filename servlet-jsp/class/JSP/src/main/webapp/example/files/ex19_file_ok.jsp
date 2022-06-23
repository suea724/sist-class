<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String path = application.getRealPath("/example/images");
	int size = 1024 * 1024 * 100;
	String fileName = "";
	
	try {
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
		
		// 업로드한 이미지명 > DB에 저장
		// fileName = multi.getFilesystemName("attach");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
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