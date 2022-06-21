<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	/* 
		클라이언트 > 서버 데이터 전송 시
		1. GET
			- URL에 붙여서 전송 > 톰캣 관련
			- UTF-8 동작
			- <form method="GET"> 태그 사용
			- 링크, location > URL을 사용하는 경우
			
		Query String
			- ?txt=홍길동&num=123
			
			
		2. POST
			- 패킷 본문에서 동작
			- ISO-8859-1 동작
			- 폼 전송 시 <form method="POST"> 태그 필요 
			
		수신되는 데이터의 인코딩 처리
		request.setCharacterEncoding("UTF-8");
	
	*/
	
	request.setCharacterEncoding("UTF-8");
	
	// 데이터 수신
	String txt = request.getParameter("txt");
	String num = request.getParameter("num");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		문자: <%= txt %>
	</div>
	<div>
		숫자: <%= num %>
	</div>	
</body>
</html>