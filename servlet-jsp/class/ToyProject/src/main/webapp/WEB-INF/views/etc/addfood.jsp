<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20556ca02cd4b892c95aa13783a3e841"></script>
<link rel="stylesheet" href="/toy/asset/css/rateit.css" />
<script type="text/javascript" src="/toy/asset/js/jquery.rateit.js"></script>
<style>
	#map {
		width: 100%;
		height: 400px;
	}
	
	.table th {
		width: 120px;
	}
	
	.table td {
		width: auto;
	}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>맛집 즐겨찾기</h2>
			 
			 <form method="POST" action="/toy/etc/addfoodok.do">
			 
			 <table class="table table-bordered">
			 	<tr>
			 		<td colspan="2"><div id="map"></div></td>
			 	</tr>
			 	<tr>
			 		<th>상호명</th>
			 		<td><input type="text" name="name" class="form-control" /></td>
			 	</tr>
			 	<tr>
			 		<th>분류</th>
			 		<td>
			 			<select name="category" class="form-control">
			 				<c:forEach var="dto" items="${list}">
			 					<option value="${dto.seq}">${dto.name}</option>
			 				</c:forEach>
			 			</select>
			 		</td>
			 	</tr>
			 	<tr>
			 		<th>별점</th>
			 		<td><div class="rateit" data-rateit-mode="font" data-rateit-resetable="false"></div></td>
			 	</tr>
			 </table>
			 
			 <div class="btns">
			 	<input type="button" value="돌아가기" class="btn btn-secondary" onclick="location.href='/toy/etc/food.do'"/>
			 	<input type="submit" value="등록하기" class="btn btn-primary" />
			 </div>
			 
			 <input type="hidden" name="lat" />
			 <input type="hidden" name="lng" />
			 <input type="hidden" name="star"/>
			 </form>
			 
		</section>
	</main>
	
	<script>
		var container = document.getElementById('map'),
	    options = {
	         center: new kakao.maps.LatLng(33.450701, 126.570667),
	         level: 3
	    };
	 
		var map = new kakao.maps.Map(container, options);
		
		let m = null;
		
		kakao.maps.event.addListener(map, 'click', function(event) {        
		    
			let lat = event.latLng.getLat();
			let lng = event.latLng.getLng();
			
			$('input[name=lat]').val(lat);
			$('input[name=lng]').val(lng);
			
			// 마커 중복 추가 X
			if (m != null) {
				m.setMap(null);
			}
			
		    m = new kakao.maps.Marker({
		    	position: event.latLng
		    });
		    
		    m.setMap(map);
		    
		});
		
		$(".rateit").bind('rated', function (event, value) {
			$('input[name=star]').val(value);
		});
	</script>

</body>
</html>