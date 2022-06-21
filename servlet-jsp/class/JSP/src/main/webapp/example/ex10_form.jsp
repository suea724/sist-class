<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery-1.12.4.js"></script>
<title>Insert title here</title>
<style>
	#box {
		background-color: #f2f2f2;
		border-radius: 5px;
		margin-top: 10px;
		height: 250px;
		padding: 20px;
	}
	
	#box > * {
		margin-bottom: 30px;
	}
</style>
</head>
<body>

	<div class="container">

	<h1>버튼 만들기</h1>
	
	<form method="POST" action="ex10_ok.jsp">

	<table class="table table-bordered">
		<tr>
			<th width=150px>너비(px)</th>
			<td><input type="number" name="width" /></td>
		</tr>
		<tr>
			<th>높이</th>
			<td><input type="number" name="height" /></td>
		</tr>
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" /></td>
		</tr>
		<tr>
			<th>배경색</th>
			<td><input type="color" name="bgColor" /></td>
		</tr>
		<tr>
			<th>글자색</th>
			<td><input type="color" name="txtColor" /></td>
		</tr>
		<tr>
			<th>글자 크기(px)</th>
			<td><input type="number" name="fontSize" /></td>
		</tr>
		<tr>
			<th>버튼 개수(ea)</th>
			<td><input type="number" name="btnCnt" /></td>
		</tr>
		<tr>
			<th>버튼 간격</th>
			<td>
				<label for="leftrightMargin">좌우 간격: </label>
				<input type="range" class="form-control input-lg" name="leftrightMargin" id="leftrightMargin"/>
				<br> 
				<label for="upDownMargin">상하 간격: </label>
				<input type="range" class="form-control input-lg" name="upDownMargin" id="upDownMargin" />
			</td>
		</tr>
		<tr>
			<th>아이콘</th>
			<td>
				<label><input type="radio" name="icon" id="" value=""/>없음</label>
				<label><input type="radio" name="icon" id="" value="🐰"/>🐰</label>
				<label><input type="radio" name="icon" id="" value="🐻"/>🐻</label>
				<label><input type="radio" name="icon" id="" value="🐻‍❄️"/>🐻‍❄️</label>
				<label><input type="radio" name="icon" id="" value="🐨"/>🐨</label>
			</td>
		</tr>
		<tr>
			<th>테두리</th>
			<td>
				<select class="form-control input-sm" name="sel" id="sel">
					<option value="n">감추기</option>
					<option value="y" selected>보이기</option>
				</select>
				<div id="box">
					<div>두께: <input type="number" name="borderWeight"></div>
					<div>색상: <input type="color" name="borderColor"></div>
					<div>
						스타일: 
						<select name="borderStyle">
							<option value="solid">실선</option>
							<option value="dashed">점선</option>
						</select>
					</div>
					<div>모서리: <input type="number" name="borderRadius"></div>
				</div>
			</td>
		</tr>
	</table>
	
	<input type="submit" value="만들기" class="btn btn-success" />
	
	</form>
	
	</div>
	
	<script>
		$('#sel').change(function() {
			if ($('#sel').val() == 'n') {
				$('#box').css('display', 'none');
			} else {
				$('#box').css('display', 'block');
			}
		});
	</script>
	
</body>
</html>