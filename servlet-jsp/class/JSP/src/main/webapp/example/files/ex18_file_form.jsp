<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/example/inc/asset.jsp" %>
<script src="/jsp/example/js/string.js"></script>
<style>
	td > div, div > div {
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<div class="container">
		<h1>다중 파일 업로드</h1>
		
		<form method="POST" action="ex18_file_ok.jsp" enctype="multipart/form-data">
		
			<table class="table table-bordered">
				<tr>
					<th>문자열</th>
					<td><input type="text" name="txt" value="홍길동"></td>
				</tr>
				<tr>
					<th>숫자</th>
					<td><input type="number" name="num" value="123"></td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
						<input type="file" name="attach1">
						
						<div id=filelist></div>
						
						<hr>
						<div>
							<input type="button" value="첨부파일 추가하기" class="btn btn-secondary" id="btnfile" />
						</div>
					</td>
					
				</tr>
			</table>
			
			<div>
				<input type="submit" value="등록하기" class="btn btn-primary">
			</div>
		</form>
	</div>
	
	<script>
	
		let no = 2;
		
		$('#btnfile').click(function() {
			let temp = '<div><input type="file" name="attach'+ no +'"><span onclick="del();">&times;</span></div>';
			//let temp = String.format('<input type="file" name="attach{0}>"', no);
			
			$('#filelist').append(temp);
			
			no ++;
		});
		
		function del() {
			$(event.target).parent().remove();
		}
	</script>

</body>
</html>