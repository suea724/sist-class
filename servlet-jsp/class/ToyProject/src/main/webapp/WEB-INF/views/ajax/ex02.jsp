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
	 		 <div>
				 <h2>기존 방식</h2>
				 <input type="text" name="" id="txt1" value="${cnt}"/>
				 <input type="button" value="확인" id="btn1" onclick="location.href='/toy/ajax/ex02data.do'"/>
			 </div>
			 <div>
			 	<input type="text"/>
			 </div>
			 
	 		 <div>
				 <h2>Ajax 방식</h2>
				 <input type="text" name="" id="txt2" value="${cnt}"/>
				 <input type="button" value="확인" id="btn2" onclick="test();"/>
			 </div>
			 <div>
			 	<input type="text" />
			 </div>
			 
			 <h2>Ajax 방식</h2>
			 <input type="button" value="확인" id="btn3" onclick="test2();"/>
			 <span id="txt3"></span>
			 
		</section>
	</main>
	
	<script>
	
		let ajax;
		
		function test() {
			
			// Ajax 통신을 지원하는 자바스크립트 객체
			ajax = new XMLHttpRequest();
			
			if (ajax != null) {
				
				ajax.onreadystatechange = m1;
				ajax.open('GET', '/toy/ajax/ex02data2.do'); // form태그의 method와 action과 유사
				ajax.send(); // submit과 유사
			} else {
				alert('접속한 브라우저가 XMLHttpRequest를 지원하지 않습니다.');
			}
		}
		
		function m1() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				
				// 서버에게 요청 후 돌려받은 데이터
				// alert(ajax.responseText);
				$('#txt2').val(ajax.responseText);                                          
			}
		}
		
		function test2() {
			
			ajax = new XMLHttpRequest();
		
			ajax.onreadystatechange = m2;
			// txt, xml, json 데이터 또는 서블릿 호출 가능
			ajax.open('GET', '/toy/data.txt');
			// ajax.open('GET', 'URL');
			ajax.send();
		}
		
		function m2() {
			console.log('ajax.readystate', ajax.readyState);
			console.log('ajax.status', ajax.status);
			
			if (ajax.readyState == 4 && ajax.status == 200) {
				console.log(ajax.responseText);
				
				// ajax.responseText > 단일 데이터
				// ajax.responseText > 다중 데이터
				
				$('#txt3').text(ajax.responseText);
			}
		}
		
	</script>

</body>
</html>