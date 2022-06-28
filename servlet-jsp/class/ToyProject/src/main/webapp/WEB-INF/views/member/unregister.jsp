<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>Unregister</h2>
			 
			 <!-- 약관 -->
			 <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
			 Hic doloremque temporibus iste quisquam sint velit fuga a maxime odit quo voluptate quis vitae quibusdam molestiae
			 sapiente animi placeat voluptatem illum.</div>
			 
			 <form method="POST" action="/toy/member/unregisterok.do">
			 <div class="btns">
			 	<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/index.do'"/>
			 	<input type="submit" value="회원탈퇴" class="btn btn-danger"/>
			 </div>
			 </form>
		</section>
	</main>
	
	<script>
		
	</script>

</body>
</html>