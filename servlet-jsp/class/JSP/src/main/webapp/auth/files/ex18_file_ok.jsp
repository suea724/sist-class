<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 파일 업로드 처리
	request.setCharacterEncoding("UTF-8");
	String path = application.getRealPath("/example/files");
	int size = 1024 * 1024 * 100;
	
	String txt = "";
	String num = "";
	
	ArrayList<String> fileNames = new ArrayList<>();
	ArrayList<String> orgFileNames = new ArrayList<>();
	
	try {
		MultipartRequest multi = new MultipartRequest(
									request,
									path,
									size,
									"UTF-8",
									new DefaultFileRenamePolicy()
								);
		
		txt = multi.getParameter("txt");
		num = multi.getParameter("num");
		
		Enumeration e = multi.getFileNames();
		
		while (e.hasMoreElements()) {
			String file = (String)e.nextElement();
			// System.out.println(file);
			
			// 하드에 저장된 이름
			fileNames.add(multi.getFilesystemName(file));
			
			// 사용자가 올린 이름
			orgFileNames.add(multi.getOriginalFileName(file));
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
<%@ include file="/example/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<div class="container">
		<h1>결과</h1>
		
		<div>문자열: <%= txt %></div>
		<div>숫자: <%= num %></div>
		<div>첨부파일: <%= fileNames.size() %>개</div>
		<ul>
			<% for (int i = 0 ; i < fileNames.size() ; i ++) { %>
			<li><a href="download.jsp?filename=<%= fileNames.get(i) %>&orgfilename=<%= orgFileNames.get(i) %>"><%= orgFileNames.get(i) %></a></li>
			<% } %>
		</ul>
	</div>
	
	<script>
	
	</script>

</body>
</html>