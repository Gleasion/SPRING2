<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register</title>
</head>
<body>
	<h2>Board Register</h2>
	<form action="/crud/board/register" method="post" id="boardForm">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" value=""></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="writer" name="writer" value=""></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="content" name="content" value=""></textarea></td>
			</tr>
		</table>
		<div>
			<button type="button" id="btnRegister">등록</button>
			<button type="button" id="btnList">목록</button>
		</div>
	</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var btnRegister = $("#btnRegister");
	var btnList = $("#btnList");
	var boardForm = $("#boardForm");
	
	btnRegister.on("click", function(){
		var title = $("#title");
		var writer = $("#writer");
		var content = $("#content");
		
		if(title == null || title == ""){
			alert("제목을 입력해주세요.")
			return false;
		}
		
		if(writer == null || writer == ""){
			alert("제목을 입력해주세요.")
			return false;
		}
		
		if(content == null || content == ""){
			alert("제목을 입력해주세요.")
			return false;
		}
		
		boardForm.submit();
	});
	
	btnList.on("click", function(){
		location.href = "/crud/board/list";
	});
	
});
</script>
</html>