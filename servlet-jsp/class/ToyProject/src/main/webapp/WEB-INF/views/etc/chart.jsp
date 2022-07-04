<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script src="/toy/asset/js/highcharts.js"></script>
<style>

</style>
</head>
<body>
	
	<main>
		<%@ include file="/WEB-INF/views/inc/header.jsp" %>
		<section>
			 <h2>Chart</h2>
			 
			 <h3>회원별 게시물 수</h3>
			 
			 <div id="chart1"></div>
			 
			 <table class="table table-bordered">
			 	<c:forEach var="dto1" items="${list1}">
			 		<tr>
			 			<td>${dto1.name}(${dto1.id})</td>
			 			<td>${dto1.cnt}</td>
			 		</tr>
			 	</c:forEach>
			 </table>
			 
			 <h3>회원별 댓글 수</h3>
			 
			 <div id="chart2"></div>
			 
			 <table class="table table-bordered">
			 	<c:forEach var="dto2" items="${list2}">
			 		<tr>
			 			<td>${dto2.name}(${dto2.id})</td>
			 			<td>${dto2.cnt}</td>
			 		</tr>
			 	</c:forEach>
			 </table>
			 
			 <h3>해시 태그</h3>
			 
			 <div id="chart3"></div>
			 
			 <table class="table table-bordered">
			 	<c:forEach var="dto3" items="${list3}">
			 		<tr>
			 			<td>${dto3.tag}</td>
			 			<td>${dto3.cnt}</td>
			 		</tr>
			 	</c:forEach>
			 </table>
			 
		</section>
	</main>
	
	<script>
        Highcharts.chart('chart1', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: ''
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.y}개</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '개'
	        }
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.y}개'
	            }
	        }
	    },
	    series: [{
	        name: '게시물 수',
	        colorByPoint: true,
	        data: [
	        	<c:forEach var="dto1" items="${list1}">
	        	{
	        		name: '${dto1.name}(${dto1.id})',
	        		y: ${dto1.cnt}
	        	},
	        	</c:forEach>
	        	]
	    	}
	    ]
	});
        
        Highcharts.chart('chart3', {
    	    chart: {
    	        plotBackgroundColor: null,
    	        plotBorderWidth: null,
    	        plotShadow: false,
    	        type: 'pie'
    	    },
    	    title: {
    	        text: ''
    	    },
    	    tooltip: {
    	        pointFormat: '{series.name}: <b>{point.y}개</b>'
    	    },
    	    accessibility: {
    	        point: {
    	            valueSuffix: '개'
    	        }
    	    },
    	    plotOptions: {
    	        pie: {
    	            allowPointSelect: true,
    	            cursor: 'pointer',
    	            dataLabels: {
    	                enabled: true,
    	                format: '<b>{point.name}</b>: {point.y}개'
    	            }
    	        }
    	    },
    	    series: [{
    	        name: '해시태그',
    	        colorByPoint: true,
    	        data: [
    	        	<c:forEach var="dto3" items="${list3}">
    	        	{
    	        		name: '${dto3.tag}',
    	        		y: ${dto3.cnt}
    	        	},
    	        	</c:forEach>
    	        	]
    	    	}
    	    ]
    	});
    </script>

</body>
</html>