<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Form</title>
</head>
<body>
	<h2>REGISTER</h2>
	<form action="/crud/board/register" method="post" id="boardForm">
		<c:if test="${status eq 'u' }">
			<input type="hidden" name="boardNo" value="${board.boardNo }"/>
		</c:if>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title2" id="title2" value="${board.title2 }"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" id="writer" value="${board.writer }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea type="text" name="content" id="content" rows="10" cols="30">${board.content }</textarea></td>
			</tr>
		</table>
	</form>
	<div>
		<c:set var="btnText" value="등록" />
		<c:if test="${status eq 'u' }">
			<c:set var="btnText" value="수정" />
		</c:if>
		<button type="button" id="btnRegister">${btnText }</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var boardForm = $("#boardForm");
	var btnRegister = $("#btnRegister");
	var btnList = $("#btnList");
	
	btnRegister.on("click", function(){
		var title = $("#title").val();
		var content = $("#content").val();
		
// 		if(title == null || title == ""){
// 			alert("제목을 입력해주세요.");
// 			return false;
// 		}
		
		if(content == null || content == ""){
			alert("내용을 입력해주세요.");
			return false;
		}
		
		if(writer == null || writer == ""){
			alert("작성자를 입력해주세요.");
			return false;
		}
		
		if($(this).text() == "수정"){
			boardForm.attr("action","/crud/board/modify");
		}
		
		boardForm.submit();
	});
	
	btnList.on("click", function(){
		location.href = "/crud/board/list";
	});
	
});
</script>
</html>