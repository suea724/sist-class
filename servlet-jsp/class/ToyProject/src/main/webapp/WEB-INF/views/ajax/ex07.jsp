<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	.table th, .table td {
		text-align: center;
	}
	
	.table td:nth-child(5) { text-align: left; }
	.table th:nth-child(1) { width: 120px; }
	.table th:nth-child(2) { width: 80px; }
	.table th:nth-child(3) { width: 80px; }
	.table th:nth-child(4) { width: 160px; }
	.table th:nth-child(5) { width: auto; }
	.table th:nth-child(6) { width: 80px; }
	
	form input, form select {
		margin: 10px 0;
	}
	
	form input[type=text] {
		width: 200px;
	}
	
	form input[type=text]:nth-child(4) {
		width: 200px;
	}
	
	form input[type=text]:nth-child(5) {
		width: 400px;
	}
	
	form select.form-control {
		width: 200px;
	}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>
			 	주소록
				<small>
					<input type="button" value="여자" class="btn btn-primary" onclick="filter('f');" />
					<input type="button" value="남자" class="btn btn-primary" onclick="filter('m');"/>
					<input type="button" value="모두" class="btn btn-primary" onclick="filter('all');"/>
				</small> 	
		 	</h2>
			 
			 <table class="table table-bordered">
			 	<thead>
			 		<tr>
			 			<th>이름</th>
			 			<th>나이</th>
			 			<th>성별</th>
			 			<th>전화</th>
			 			<th>주소</th>
			 			<th>삭제</th>
			 		</tr>
			 	</thead>
			 	<tbody>
			 		<c:if test="${empty list}">
			 		<tr>
			 			<td colspan="6">회원이 존재하지 않습니다.</td>
			 		</tr>
			 		</c:if>
			 		
			 		<c:if test="${not empty list}">
			 		<c:forEach var="dto" items="${list}">
			 		<tr>
			 			<td>${dto.name}</td>
			 			<td>${dto.age}</td>
			 			<td>${dto.gender == 'f' ? '여자' : '남자'}</td>
			 			<td>${dto.tel}</td>
			 			<td>${dto.address}</td>
			 			<td><input type="button" value="삭제" class="btn btn-danger" onclick="del(${dto.seq});" /></td>
			 		</tr>
			 		</c:forEach>
			 		</c:if>
			 	</tbody>
			 </table>
			 
			 <hr>
			 
			 <form id="form">
			 	<div>
			 		<input type="text" name="name" id="name" class="form-control" placeholder="이름">
			 		<input type="text" name="age" id="age" class="form-control" placeholder="나이">
			 		<select name ="gender" id="gender" class="form-control">
			 			<option value="f">여자</option>
			 			<option value="m">남자</option>
			 		</select>
			 		<input type="text" name="tel" id="tel" class="form-control" placeholder="전화">
			 		<input type="text" name="address" id="address" class="form-control" placeholder="주소">
			 	</div>
			 	<div class="btns">
			 		<input type="button" value="등록하기" class="btn btn-primary" id="btnAdd" />
			 	</div>
			 </form>
			 
		</section>
	</main>
	
	<script>
		function del(seq) {
			
			$.ajax({
				type: 'GET',
				url: '/toy/ajax/ex07del.do',
				data: "seq=" + seq,
				dataType: "json",
				success: function(result) {
					
					if (result.result == '1') {
						alert('삭제 성공!');
					} else {
						alert('삭제 실패]');
					}
					
					let temp = '';
					
					$(result.list).each(function(index, item) {
						temp += '<tr>';
						temp += '<td>'+ item.name +'</td>';
						temp += '<td>'+ item.age +'</td>';
						temp += '<td>'+ (item.gender == 'f' ? '여자' : '남자') +'</td>';					
						temp += '<td>'+ item.tel +'</td>';					
						temp += '<td>'+ item.address +'</td>';	
						temp += '<td><input type="button" value="삭제" class="btn btn-danger" onclick="del(' + item.seq + ')" /></td>'
						temp += '</tr>';
					});
					
					$('table tbody').html('');
					$('table tbody').append(temp);
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		}
		
		$('#btnAdd').click(function() {
			$.ajax({
				type: 'POST',
				url: '/toy/ajax/ex07add.do',
				data: $('#form').serialize(),
				dataType: "json",
				success: function(result) {
					
					let temp = '';
					
					$(result).each(function(index, item) {
						temp += '<tr>';
						temp += '<td>'+ item.name +'</td>';
						temp += '<td>'+ item.age +'</td>';
						temp += '<td>'+ (item.gender == 'f' ? '여자' : '남자') +'</td>';					
						temp += '<td>'+ item.tel +'</td>';					
						temp += '<td>'+ item.address +'</td>';
						temp += '<td><input type="button" value="삭제" class="btn btn-danger" onclick="del(' + item.seq + ')" /></td>'
						temp += '</tr>';
					});
					
					$('table tbody').html('');
					$('table tbody').append(temp);
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		});
		
		function filter(arg) {
			
			$.ajax({
				type: 'GET',
				data: 'filter=f',
				url: '/toy/ajax/ex07filter.do',
				data: "filter=" + arg,
				dataType: 'json',
				success: function(result) {
					
					let temp = '';
					
					$(result).each(function(index, item) {
						
						temp += '<tr>';
						temp += '<td>'+ item.name +'</td>';
						temp += '<td>'+ item.age +'</td>';
						temp += '<td>'+ (item.gender == 'f' ? '여자' : '남자') +'</td>';					
						temp += '<td>'+ item.tel +'</td>';					
						temp += '<td>'+ item.address +'</td>';
						temp += '<td><input type="button" value="삭제" class="btn btn-danger" onclick="del(' + item.seq + ')" /></td>'
						temp += '</tr>';
					});
					
					$('table tbody').html('');
					$('table tbody').append(temp);
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		}
		
		
	</script>

</body>
</html>