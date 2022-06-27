<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--

	상대경로
	절대경로 
		- '/' > http://localhost:8090
-->
	 
<!-- 	 
<link rel="stylesheet" href="../css/bootstrap.css" />
-->


<link rel="stylesheet" href="<%= request.getContextPath() %>/auth/css/bootstrap.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/auth/css/auth.css" />

<script src="<%= request.getContextPath() %>/example/js/jquery-1.12.4.js"></script>
<script src="<%= request.getContextPath() %>/example/js/bootstrap.js"></script>
