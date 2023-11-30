<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Login Form</title>
</head>
<body>
	<h1>Login</h1>
	<h2><c:out value="${error }"/></h2>		<!-- 에러 발생 시, 출력할 메세지 -->
	<h2><c:out value="${logout }"/></h2>	<!-- 로그아웃 시, 출력할 메세지 -->
	
	<form action="/login" method="post">
		username : <input type="text" name="username" value=""/><br/>
		password : <input type="text" name="password" value=""/><br/>
		<input type="checkbox" name="remember-me"/> Remember Me
		<input type="submit" value="로그인"/>
		<sec:csrfInput/>			<!-- csrf Token에 관한 정보가 담겨져 있는 tag -->
	</form> 
</body>
</html>