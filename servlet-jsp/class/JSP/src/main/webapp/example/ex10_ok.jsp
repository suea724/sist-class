<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String txt = request.getParameter("txt");
	String fontSize = request.getParameter("fontSize");
	int btnCnt = Integer.parseInt(request.getParameter("btnCnt"));
	String icon = request.getParameter("icon");
	String bgColor = request.getParameter("bgColor");
	String txtColor = request.getParameter("txtColor");
	String leftrightMargin = request.getParameter("leftrightMargin");
	String upDownMargin = request.getParameter("upDownMargin");
	
	String borderWeight = request.getParameter("borderWeight");
	String borderStyle = request.getParameter("borderStyle");
	String borderColor = request.getParameter("borderColor");
	String borderRadius = request.getParameter("borderRadius");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<style>
	input[type=button] {
		width: <%= width %>px;
		height: <%= height %>px;
		font-size: <%= fontSize %>px;
		background-color : <%= bgColor %>;
		color: <%= txtColor %>;
		margin: <%= upDownMargin %>px <%= leftrightMargin %>px ;
		border: <%= borderWeight%>px <%= borderStyle%> <%= borderColor %>;
		border-radius: <%= borderRadius %>px;
		
	}
</style>
</head>
<body>
	<div class="container">
	<h1>결과</h1>
		<table class="table table-bordered text-center">
			<tr>
				<td>버튼</td>
			</tr>
			<tr>
				<td>
					<% for (int i = 0 ; i < btnCnt ; i ++) { %>
					<input type="button" value="<%= icon + txt %>">
					<% } %>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>