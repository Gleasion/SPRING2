<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Register</title>
</head>
<body>
	<h2>REGISTER</h2>
	<form action="/crud/member/register" method="post" id="memberForm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userId" name="userId"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="userPw" name="userPw"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="userName" name="userName"/></td>
			</tr>
		</table>
	</form>
	<div>
		<button type="button" id="btnRegister">등록</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var btnRegister = $("#btnRegister");
	var btnList = $("#btnList");
	var memberForm = $("#memberForm");
	
	btnRegister.on("click", function(){
		var id = $("#userId").val();
		var pw = $("#userPw").val();
		var name = $("#userName").val();
	
		if(id == null || id == ""){
			alert("아이디를 입력해주세요.");
			return false;
		}
		
		if(pw == null || pw == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
		if(name == null || name == ""){
			alert("이름 입력해주세요.");
			return false;
		}
	
		memberForm.submit();
	
	});
	
	btnList.on("click",function(){
		location.href = "/crud/member/list";
	});
	
});
</script>
</html>