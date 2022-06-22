<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// System.out.println(pageContext.getRequest() == request); // true
	// System.out.println(pageContext.getResponse() == response); // true
	
	// response.sendRedirect() vs pageContext.forward()
	// 페이지 이동 메서드
	
	
	// 업무 코드 가정
	int num = 10;
	
	// 페이지 간 데이터를 전달하는 방법
	// 1. <form>
	// 2. QueryString
	// 3. 내장 객체 > 컬렉션 사용
	
	// pageContext, request, sesison, application > 객체 내부에 사용자 정의 데이터를 저장하고 있는 컬렉션을 가지고 있다.
	// 서버쪽에서 페이지 이동
	// 	1. sendReidrect()
	//  2. forward()
	
	request.setAttribute("num", num);
	
	// response.sendRedirect("ex13_pagecontext_2.jsp"); // 페이지 이동만
	// http://localhost:9090/jsp/example/ex13_pagecontext_2.jsp
	
	// request, response를 같이 전달한다. > 이동된 페이지에서 request, response를 새로 생성하지 않고 이전페이지의 것을 사용
	pageContext.forward("ex13_pagecontext_2.jsp"); // 페이지 이동 + 데이터 전달
	// http://localhost:9090/jsp/example/ex13_pagecontext_1.jsp

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
		<h1>1번 페이지</h1>
	</div>
	
	<script>
	
	</script>

</body>
</html>