<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Modify</title>
</head>
<body>
	<h2>MODIFY</h2>
	<form action="/crud/member/modify" method="post" id="memberForm">
	<input type="hidden" name="userNo" value="${member.userNo }">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" value="${member.userId }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" id="userName" value="${member.userName }"/></td>
			</tr>
			<tr>
				<td>역할명1</td>
				<td>
					<select name="authList[0].auth">
						<option value="">===선택해주세요===</option>
						<option value="ROLE_USER" <c:if test="${member.authList[0].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[0].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[0].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>역할명2</td>
				<td>
					<select name="authList[1].auth">
						<option value="">===선택해주세요===</option>
						<option value="ROLE_USER" <c:if test="${member.authList[1].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[1].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[1].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>역할명3</td>
				<td>
					<select name="authList[2].auth">
						<option value="">===선택해주세요===</option>
						<option value="ROLE_USER" <c:if test="${member.authList[2].auth eq 'ROLE_USER' }">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[2].auth eq 'ROLE_MEMBER' }">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[2].auth eq 'ROLE_ADMIN' }">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<div>
		<button type="button" id="btnModify">수정</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var btnModify = $("#btnModify");
	var btnList = $("#btnList");
	var memberForm = $("#memberForm");
	
	btnModify.on("click", function(){
		var name = $("#userName").val();
		
		if(name == null || name == ""){
			alert("이름을 입력해주세요!");
			return false;
		}
		
		memberForm.submit();
	});
	
	btnList.on("click", function(){
		location.href = "/crud/member/list";
	});
	
});
</script>
</html>