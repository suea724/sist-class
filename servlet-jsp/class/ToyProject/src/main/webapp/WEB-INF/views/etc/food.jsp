<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20556ca02cd4b892c95aa13783a3e841"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<link rel="stylesheet" href="/toy/asset/css/rateit.css" />
<script type="text/javascript" src="/toy/asset/js/jquery.rateit.js"></script>
<style>
	#map {
		width: 500px;
		height: 400px;
	}
	
	.table .table {
		width: 250px;
	}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>맛집 리스트</h2>
			 
			 <table class="table table-bordered">
			 	<tr>
			 		<td>
			 			<div id="map"></div>
		 			</td>
			 		<td>
			 			<table class="table table-bordered">
			 				
		 					<c:forEach var="dto" items="${list}">
		 						<tr>
		 							<td>
		 								<span class="${dto.icon}"></span>
		 								<a href="#!" onclick="selFood(${dto.lat}, ${dto.lng}, ${dto.category})">${dto.name}</a>(<span class="rateit" data-rateit-value="${dto.star}" data-rateit-resetable="false" data-rateit-readonly="true"></span>)
		 							</td>
		 						</tr>
		 					</c:forEach>
			 				
			 			</table>
			 		</td>
			 	</tr>
			 
			 </table>
			 
			 <div class="btns">
			 	<input type="button" value="등록하기" class="btn btn-primary" onclick="location.href='/toy/etc/addfood.do'">
			 </div>
			 
		</section>
	</main>
	
	<script>
		var container = document.getElementById('map'),
	    options = {
	         center: new kakao.maps.LatLng(33.450701, 126.570667),
	         level: 3
	    };
	 
		var map = new kakao.maps.Map(container, options);
		
		<%--
		<c:forEach var="dto" items="${list}" varStatus="status">
			let m${status.index} = new kakao.maps.Marker({
		    	position: new kakao.maps.LatLng(${dto.lat}, ${dto.lng})
		    });
		    
		    m${status.index}.setMap(map);
		    
		</c:forEach>
		--%>
		
		/* let m = null;
		
		function selFood(lat, lng) {
			map.panTo(new kakao.maps.LatLng(lat, lng));
			
			if (m != null) {
				m.setMap(null);
			}
			
			m = new kakao.maps.Marker({
				position: new kakao.maps.LatLng(lat, lng)
			});
			
			m.setMap(map);
			
		} */
		
		let m = null;
		
		function selFood(lat, lng, category) {
			
			map.panTo(new kakao.maps.LatLng(lat, lng));
		
			var imageSrc = '/toy/pic/m' + category + '.png', // 마커이미지의 주소입니다    
		    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
		    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		      
			// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
			    markerPosition = new kakao.maps.LatLng(lat, lng); // 마커가 표시될 위치입니다
		
			// 마커를 생성합니다
			m = new kakao.maps.Marker({
			    position: markerPosition, 
			    image: markerImage // 마커이미지 설정 
			});
			
			m.setMap(map);
		}
		    
	</script>

</body>
</html>