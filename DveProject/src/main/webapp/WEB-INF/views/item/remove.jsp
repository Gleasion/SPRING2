<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Remove</title>
</head>
<body>
	<h2>REMOVE</h2>
		<form action="/item/remove" method="post" enctype="multipart/form-data">
			<input type="hidden" name="itemId" value="${item.itemId }"/>
			<table>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="itemName" id="itemName" value="${item.itemName }" disabled="disabled"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price" id="price" value="${item.price }" disabled="disabled"/>&nbsp;원</td>
				</tr>
				<tr>
					<td>파일</td>
					<td><img src="/item/display?itemId=${item.itemId }" width="210" height="240"/></td>
				</tr>
				<tr>
					<td>개요</td>
					<td><textarea rows="10" cols="30" name="description" disabled="disabled">${item.description }</textarea></td>
				</tr>
			</table>
			<div>
				<button type="submit">삭제</button>
				<button type="button" onclick="javascript:location.href='/item/list'">목록</button>
			</div>
		</form>
</body>
</html>