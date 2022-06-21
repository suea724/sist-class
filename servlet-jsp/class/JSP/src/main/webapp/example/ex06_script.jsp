<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// JDBC를 사용해서 select 결과를 출력한다고 가정
	ArrayList<String> list = new ArrayList<>();

	list.add("홍길동");
	list.add("아무개");
	list.add("하하하");
	list.add("호호호");
	list.add("후후후");
	
	ArrayList<String> color = new ArrayList<>();
	color.add("cornflowerblue");
	color.add("plum");
	color.add("gold");
	color.add("tomato");
	color.add("orange");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.item {
		border: 1px solid #AAA;
		border-radius: 5px;
		padding: 15px;
		width: 450px;
		margin-bottom: 5px;
		
	}
</style>
</head>
<body>
	<h1>Member</h1>
	
	<% for (int i = 0 ; i < list.size() ; i ++) { %>
	
	<div class="item" style="background-color: <%= color.get(i) %>;">
		<h2><%= list.get(i) %></h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illo soluta incidunt ipsum aspernatur distinctio quo minima saepe nihil est quibusdam? Hic omnis illum neque eum assumenda temporibus maxime molestiae dolorum.</p>
		<input type="button" value="자세히보기" class="btn" onclick="info('<%= list.get(i) %>')" />
	</div>
	
	 <% } %>
	 
	 <script>
	 	function info(name) {
	 		alert('회원: ' + name);
	 	}
	 </script>
</body>
</html>