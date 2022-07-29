<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<tiles:insertAttribute name="asset" />
</head>
<body>
	<div id="main">
		<tiles:insertAttribute name="mainmenu" />		
		<tiles:insertAttribute name="submenu" />		
		<tiles:insertAttribute name="content" />		
	</div>
</body>
</html>