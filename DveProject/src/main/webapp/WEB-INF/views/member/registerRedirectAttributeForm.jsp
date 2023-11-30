<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerRedirectAttributeForm</title>
</head>
<body>
	<h3>registerRedirectAttributeForm</h3>
	
	<p>1) 기본 자료형은 매개변수로 선언하더라도 기본적으로 전달되지 않는다.</p>
	<form action="/redirectattribute/register" method="post">
		userId : <input type="text" name="userId" value="hongkd" /><br/>
		password : <input type="text" name="password" value="1234" /><br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	
	
	
</body>
</html>