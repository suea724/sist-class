<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	a {
		display: block;
		margin-bottom: 5px;
	}
</style>
</head>
<body>

	<div class="container">
	
		<h1>세션, Session</h1>
		
		<a href="ex16_set.jsp">세션값 저장하기</a>
		<a href="ex16_del.jsp">세션값 삭제하기</a>
		<a href="ex16_reset.jsp">세션값 초기화하기</a>
		<a href="ex16_interval.jsp">세션 만료 시간 지정하기</a>
		
		<hr>
		
		<!-- 세션 객체의 고유 식별자 -->
		<div>Session ID: <%= session.getId() %></div>
		
		<!-- 세션 객체 생성 시각 -->
		<div>
			Session Creation Time: 
				<%
					Calendar temp = Calendar.getInstance();
					temp.setTimeInMillis(session.getCreationTime());
					out.println(String.format("%tF %tT", temp, temp));
				%>
		</div>
		
		<!-- 세션 만료 시간(1800초, 30분) -->
		<div>Session Max Inactive Interval: <%= session.getMaxInactiveInterval() %></div>
		
		<!-- 새로 생성된 세션인지 여부 -->
		<div>Session isNew : <%= session.isNew() %></div>
		
		<!-- 세션 저장소(데이터) -->
		<% if(session.getAttribute("data") != null) { %>
			<div>Session Data: <%= session.getAttribute("data") %></div>
		<% } else { %>
			<div>Session Data : 데이터 없음</div>
		<% } %>
	
	</div>
	
	<script>
	
	</script>

</body>
</html>