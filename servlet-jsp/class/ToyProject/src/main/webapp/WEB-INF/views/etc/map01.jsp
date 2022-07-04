<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20556ca02cd4b892c95aa13783a3e841"></script>
<style>
	#map {
		width: 750px;
		height: 400px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>카카오 맵</h2>
			 <div id="map"></div>
			 
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
		    
			// 마커 중복 추가 X
			if (m != null) {
				m.setMap(null);
			}
			
		    m = new kakao.maps.Marker({
		    	position: event.latLng
		    });
		    
		    m.setMap(map);
		    
		});
	
	</script>

</body>
</html>