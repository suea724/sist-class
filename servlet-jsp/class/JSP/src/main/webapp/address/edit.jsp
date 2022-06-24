<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 데이터 가져오기(?seq=5)
	// 2. DB 작업 > select * from tblAddress where seq = 5;
	// 3. 결과 > 폼태그 기본값 설정하기
	
	// 1. 데이터 가져오기(?seq=5)
	String seq = request.getParameter("seq");
	
	// 2.
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	conn = DBUtil.open();
	
	String sql = "select * from tblAddress where seq = ?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, seq);
	
	rs = pstmt.executeQuery();
	
	// 3.
	String name = "";
	String age = "";
	String gender = "";
	String tel = "";
	String address = "";
	
	if (rs.next()) {
		name = rs.getString("name");
		age = rs.getString("age");
		gender = rs.getString("gender");
		tel = rs.getString("tel");
		address = rs.getString("address");
	}
	
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/address/inc/asset.jsp" %>
<style>

</style>
</head>
<body>

	<!-- template.jsp > add.jsp > edit.jsp -->
	<main>
		<header>
			<%@ include file="/address/inc/header.jsp" %>
		</header>
		<section>
			<div class="section content">
				<form method="POST" action="editok.jsp">
					<table class="table table-bordered">
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" required class="form-control short"/></td>
						</tr>
						<tr>
							<th>나이</th>
							<td><input type="number" name="age" required min="18" max="120" class="form-control short" /></td>
						</tr>
						<tr>
							<th>성별</th>
							<td>
								<label><input type="radio" name="gender" value="m" />남자</label>
								<label><input type="radio" name="gender" value="f" />여자</label>
							</td>
						</tr>
						<tr>
							<th>전화</th>
							<td><input type="text" name="tel" required class="form-control middle" /></td>
						</tr>
						<tr>
							<th>주소</th>
							<td><input type="text" name="address" class="form-control" /></td>
						</tr>

					</table>
					
					<div class="btns">
						<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/jsp/address/list.jsp';">
	                  <input type="submit" value="수정하기" class="btn btn-primary">
					</div>
					
					<input type="hidden" name="seq" value="<%= seq %>">
					
				</form>
			</div>
		</section>	
	</main>
	
	<script>
		$('input[name=name]').val('<%= name %>');
		$('input[name=age]').val('<%= age %>');
		$('input[name=gender]').val('<%= gender %>');
		$('input[name=tel]').val('<%= tel %>');
		$('input[name=address]').val('<%= address %>');
	</script>

</body>
</html>
















