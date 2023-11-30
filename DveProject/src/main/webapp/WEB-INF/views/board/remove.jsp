<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REMOVE</title>
</head>
<body>
	<h3>REMOVE</h3>
	
	<form action="/board/post" method="post">
		<input type="submit" name="remove" value="Remove" />
	</form>
	
	<a href="/board/get?list">List</a>
</body>
</html>