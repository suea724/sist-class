<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.test.jsp.TodoDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	conn = DBUtil.open();
	
	stmt = conn.createStatement();
	String sql = "select * from tblTodo";
	rs = stmt.executeQuery(sql);
	
	ArrayList<TodoDto> list = new ArrayList<>();
	
	while(rs.next()) {
		TodoDto dto = new TodoDto(rs.getString("seq"),
										rs.getString("todo"),
										rs.getString("regdate"),
										rs.getString("priority"),
										rs.getString("complete"));
		list.add(dto);
	}
	
	list.sort(new Comparator<TodoDto>() {
		public int compare(TodoDto a, TodoDto b) {
			return a.getRegdate().compareTo(b.getRegdate());
		}
	});
	
	pageContext.setAttribute("list", list);
	
%>

<%!
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@ include file="/todo/inc/asset.jsp" %>
<style>
</style>
</head>
<body>

	<main>
		<h1>Todo <small>List</small></h1>
		
		<table class="table table-bordered list">
			<tr>
				<th>중요도</th>
				<th>할일</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.priority}</td>
					<td onclick="update(event, ${dto.seq});">${dto.todo}</td>
					<td>${dto.regdate}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="btns">
			<input type="button" value="등록하기"
				class="btn btn-warning" onclick="location.href='add.jsp';">
		</div>
	</main>
	
	<script>

		function update(event, seq) {
			if (event.target.parentElement.className == '') {
				event.target.parentElement.className = 'complete';
			} else {
				event.target.parentElement.className = '';
			}
		}
	</script>

</body>
</html>

