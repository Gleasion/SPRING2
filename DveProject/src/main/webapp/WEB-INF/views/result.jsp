<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h3>Result</h3>
	userId : ${userId }<br/>
	password : ${password }<br/>
	
	member.userId : ${member.userId }<br/>
	member.password : ${member.password }<br/>
	
	<c:if test="${not empty member.address.postCode }">
		member.address.postCode : ${member.address.postCode }<br/>
	</c:if>
	<c:if test="${not empty member.address.location }">
		member.address.location : ${member.address.location }<br/>
	</c:if>
	
	<!-- RedirectAttribute를 사용시 출력 -->
	msg : ${msg }
	
	
</body>
</html>