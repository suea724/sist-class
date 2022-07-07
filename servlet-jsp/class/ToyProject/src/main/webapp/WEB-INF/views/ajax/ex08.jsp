<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script src="/toy/asset/js/jquery-ui.js"></script>
<style>

</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>jQuery + Ajax</h2>
			 <img src="/toy/pic/m1.png" class="drag" id="m1">
			 <img src="/toy/pic/m2.png" class="drag" id="m2">
			 <img src="/toy/pic/m3.png" class="drag" id="m3">
			 
			 
		</section>
	</main>
	
	<script>
	
		$('.drag').draggable({
			stop: function(event, ui) {
				// 정보
				let id = this.id;
				let x = ui.position.left;
				let y = ui.position.top;
				
				// alert(id + ', ' + x + ',' +  y);
				$.ajax({
					type: 'POST',
					url: '/toy/ajax/ex08data.do',
					data: 'id=' + id + '&x=' + x + '&y=' + y,
					dataType: 'json',
					success: function(result) {
						if (result.result == "1") {
							
						} else {
							
						}
					},
					error: function(a, b, c) {
						console.log(a, b, c);
					}
				})
			}	
		});
		
		<c:forEach var="dto" items="${list}">
		$('#${dto.id}').css({
			left: '${dto.left}px',
			right: '${dto.top}px'
		});
		</c:forEach>
		
	</script>

</body>
</html>