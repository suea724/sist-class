<%@page import="java.util.Comparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 디렉토리 탐색
	String path = application.getRealPath("/example/images");

	File dir = new File(path);
	File[] list = dir.listFiles(); 
	
	// System.out.println(Arrays.toString(list)); // 모든 파일의 경로 + 파일명
	// System.out.println(list[0].getName()); // 파일명만
	
	// 가장 최근에 업로드한 것이 처음에 오도록 정렬
	Arrays.sort(list, new Comparator<File>() {
		
		public int compare(File a, File b) {
			return Long.compare(b.lastModified(), a.lastModified());			
		}
	});

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<style>
	#list {
		width: 800px;
	}
	
	#list > div {
		float: left;
		border: 1px solid #999;
		margin: 15px;
		width: 126px;
		height: 126px;
		background-size: cover;
		background-repeat: no-repeat;
	}
	
	#list::after {
		content: '';
		display: block;
		clear: both;
	}
	
	/* #list > div > img {
		width: 126px;
		height: 126px;
	} */
	
	.modal-body > img {
		display: block;
		margin: 15px auto;
		max-width: 1000px;
	}
	
	#delete {
		cursor: pointer;
	}
</style>
</head>
<body>

	<div class="container">
		<h1>Image Gallery</h1>
		
		<div id="list">
			<% for(File img : list) { %>
			<%-- <div><img src="../images/<%= img.getName() %>"></div> --%>
			<div style="background-image:url(../images/<%= img.getName() %>);" data-toggle="modal" data-target="#exampleModal" onclick="showImage('<%= img.getName() %>')">
				<span id="delete" title="delete" onclick="deleteImage('<%= img.getName() %>');">&times;</span>
			</div>
			<% } %>
		
		</div>
		
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered modal-xl">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
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
		
		<form method="POST" action="ex19_file_ok.jsp" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<th>이미지</th>
					<td><input type="file" name="attach" required></td>
				</tr>
			</table>
			
			<div>
				<input type="submit" value="이미지 업로드" class="btn btn-primary">
			</div>
		</form>
	</div>
	
	<script>
		function showImage(img) {
			$('.modal-body > img').attr('src', '../images/' + img);
			$('#exampleModalLabel').text(img);
		}
		
		function deleteImage(img) {
			
			if (confirm('삭제 하시겠습니까?')) {
				location.href = 'ex19_file_delete.jsp?filename=' + img;
			}
		}
	</script>

</body>
</html>