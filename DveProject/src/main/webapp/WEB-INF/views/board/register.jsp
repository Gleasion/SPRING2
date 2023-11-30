<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
	<h3>REGISTER</h3>
	
	<form action="/board/post" method="post">
		<input type="submit" name="register" value="Register" />
	</form>
	
	<a href="/board/get?list">List</a>
	
</body>
</html>