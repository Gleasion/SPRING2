<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Read</title>
</head>
<body>
	<h2>READ</h2>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<td>역할명1</td>
			<td>${member.authList[0].auth }</td>
		</tr>
		<tr>
			<td>역할명2</td>
			<td>${member.authList[1].auth }</td>
		</tr>
		<tr>
			<td>역할명3</td>
			<td>${member.authList[2].auth }</td>
		</tr>
	</table>
	<form action="/crud/member/remove" method="post" id="delForm">
		<input type="hidden" name="userNo" value="${member.userNo }">
	</form>
	<div>
		<button type="button" id="btnModify">수정</button>
		<button type="button" id="btnRemove">삭제</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var btnModify = $("#btnModify");
	var btnRemove = $("#btnRemove");
	var btnList = $("#btnList");
	var delForm = $("#delForm");
	
	btnModify.on("click", function(){
		location.href = "/crud/member/modify?userNo=${member.userNo}"
	});
	
	btnRemove.on("click", function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			delForm.submit();
		}
	});
		
	btnList.on("click", function(){
		location.href = "/crud/member/list";
	});
		
});
</script>
</html>