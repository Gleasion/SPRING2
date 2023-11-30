<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>READ</title>
</head>
<body>
	<h3>READ</h3>
	
	<form action="/board/get" method="get">
		<input type="submit" name="modify" value="Modify" />
		<input type="submit" name="remove" value="Remove" />
	</form>
	
	<a href="/board/get?list">List</a>
</body>
</html>