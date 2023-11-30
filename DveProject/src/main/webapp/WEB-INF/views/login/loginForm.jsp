<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form Page</title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="/login1" method="post">
		아이디 : <input type="text" name="userId"/><br/>
		비밀번호 : <input type="text" name="userPW"/><br/>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>