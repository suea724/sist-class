<%@page import="com.test.jsp.DBUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.test.jsp.ImageDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	conn = DBUtil.open();
	
	stmt = conn.createStatement();
	
	String sql = "select * from tblGallery";
	
	rs = stmt.executeQuery(sql);
	
	ArrayList<ImageDto> list = new ArrayList<>();
	
	while (rs.next()) {
		ImageDto dto = new ImageDto(rs.getString("seq"),
										rs.getString("filename"),					
										rs.getString("subject"),					
										rs.getString("regdate"));
		list.add(dto);
	}
	
	list.sort(new Comparator<ImageDto>() {
		public int compare(ImageDto a, ImageDto b) {
			return b.getRegdate().compareTo(a.getRegdate());
		}
	});
	
	pageContext.setAttribute("list", list);
%>    
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/gallery/inc/asset.jsp" %>
<style>

	.container {
		width: 810px;
		margin-bottom: 100px;
	}
	
	#list {
		width: 800px;
		margin-top: 20px;
		margin-bottom: 0px;
	}
	
	#list > div {
		float: left;
		border: 1px solid #999;
		margin: 15px;
		margin-bottom: 50px;
		width: 126px;
		height: 126px;
		background-size: cover;
		background-repeat: no-repeat;
		background-position: center center;
		position: relative;
		left: 0;
		top: 0;
	}
	
	#list > div > span {
		font-size: 1.5em;
		position: absolute;
		right: 6px;
		top: 0;
		cursor: pointer;
		display: none;
	}
	
	#list > div > .title {
		position: absolute;
		font-size: 12px;
		left: -1px;
		top: 130px;
		padding-left: 5px;
		width: 126px;
		text-align: center;
	}
	
	#list > div:hover > span {
		display: inline;
	}
	
	#list::after {
		content: '';
		display: block;
		clear: both;
	}	
	
	.modal-body > img {
		display: block;
		margin: 15px auto;
		max-width: 560px;
	}
	
	
	#exampleModal .modal-dialog {
       -webkit-transform: translate(0,-50%);
       -o-transform: translate(0,-50%);
       transform: translate(0,-50%);
       top: 50%;
       margin: 0 auto;
   }
</style>를
</head>
<body>

	<!-- list.jsp -->
	<div class="container">
		<h1>Image Gallery <small>List</small></h1>
		
		<div id="list">
		
			<c:forEach var="dto" items="${list}">
			
				<div style="background-image:url(images/${dto.fileName});" data-toggle="modal" data-target="#exampleModal" onclick="showImage('${dto.fileName}', '${dto.subject}', '${dto.regdate}');">
					<span title="delete" onclick="deleteImage(${dto.seq});">&times;</span>
					<div class="title">${dto.subject}</div>
				</div>
			
			</c:forEach>
				
		</div>

		<input type="button" value=" 이미지 업로드 "
				class="btn btn-success" onclick="location.href='add.jsp';">
					

	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-xl">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel"><span></span><span style="float:right; color: #999; margin-top: 5px; font-size: 12px;"></span></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	        </button>
	      </div>
	      <div class="modal-body">
	      	<img>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
	
		function showImage(img, title, regdate) {

			$('.modal-body > img').attr('src', 'images/'+ img);
			$('#exampleModalLabel > span').eq(0).text(title + '(' + img + ')');
			$('#exampleModalLabel > span').eq(1).text(regdate); 			
		}
		
		function deleteImage(seq) {
			//alert(img);
						
			if (confirm('삭제하시겠습니까?')) { 
				location.href = 'delok.jsp?seq=' + seq;
			}
			
			event.stopPropagation();
			
		}
	
	</script>

</body>
</html>
