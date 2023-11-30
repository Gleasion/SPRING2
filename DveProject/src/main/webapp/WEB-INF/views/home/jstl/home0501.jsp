<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p> JSTL 태그들의 Exam</p>
	<p>모든 c:when태그의 test 결과값이 false이면 c:otherwise가 실행된다.</p>
	
	<c:choose>
		<c:when test="${member.gender == 'M' }">
			<p>male</p>
		</c:when>
		<c:when test="${member.gender == 'F' }">
			<p>female</p>
		</c:when>
		<c:otherwise>others</c:otherwise>
	</c:choose>
</body>
</html>