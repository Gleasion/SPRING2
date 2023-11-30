<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result2</title>
</head>
<body>
	<h3>Result2</h3>
	<h4>carList : </h4>
	<c:forEach items="${member.carList }" var="car">
		<c:out value="${car }" /><br/>
	</c:forEach>
</body>
</html>