<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	
	/*
		<form enctype="multipart/form-data">
		- request.getParameter(), request.getParameterValues() 동작 X
		- cos.jar > MultipartRequest 대신 사용
		
		MultipartRequest
		1. request > Wrapping Class > request 역할을 그대로 구현
		2. 파일 업로드 처리 구현

		업로드 될 파일들이 위치할 폴더의 로컬 경로 필요!
		- B:\\class\\server\JSPTest\src\main\webapp\example\files
			
		application.getRealPath("/example/files") > 아파치 톰캣이 실제로 서버를 운영하기 위해 원본 소스를 복사해놓은 실제 운영 디렉토리(***)
		- B:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\example\files
		
		
		업로드 파일의 최대 크기 지정(바이트 단위)
		
	*/
	
	String path = application.getRealPath("/example/files");
	
	int size = 1024 * 1024 * 100; // 100MB
	
	// 변수 선언
	String txt = "";			
	String num = "";
	String fileName = "";
	String orgFileName = "";
	
	try {
		// com.oreilly.servlet.MultipartRequest
		// MultipartRequest 객체 생성 순간 이미 첨부 파일은 files 폴더에 업로드 완료
		MultipartRequest multi = new MultipartRequest(
									request, // 원래 request 객체
									path, 	// 업로드 위치
									size,	// 최대 크기
									"UTF-8", // 인코딩 지정
									new DefaultFileRenamePolicy()
								);
		
		// 전송 데이터 가져오기
		txt = multi.getParameter("txt");
		num = multi.getParameter("num");
		
		// 파일 정보 가져오기
		fileName = multi.getFilesystemName("attach"); // 하드 디스크에 저장된 진짜 이름
		orgFileName = multi.getOriginalFileName("attach"); // 사용자가 올린 원본의 이름
		
		
	} catch(Exception e) {
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
		
		<div class="card card-body bg-light">
			<strong>문자열</strong>
			<%= txt %>
		</div>
		<div class="card card-body bg-light">
			<strong>숫자</strong>
			<%= num %>
		</div>
		<div class="card card-body bg-light">
			<strong>파일</strong>
			<%= fileName %>, <%= orgFileName %>
		</div>
		
		<h1>파일 다운로드</h1>
		<div>
			<a href="/jsp/example/files/<%= fileName %>"><%= fileName %></a>
		</div>
		
		<div>
			<a href="/jsp/example/files/<%= fileName %>" download><%= fileName %></a> <!-- 해석하지 않고 다운로드 -->
		</div>
		
		<div>
			<a href="download.jsp?filename=<%= fileName %>&orgfilename=<%= orgFileName %>"><%= orgFileName %></a>
		</div>
	</div>
	
	<script>
	
	</script>

</body>
</html>