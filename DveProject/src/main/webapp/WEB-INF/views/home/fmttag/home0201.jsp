<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<p>2) type 속성이 지정되지 않으면 기본값은 number이다.</p>
	<p>coin : ${coin }</p>
	<p><fmt:parseNumber value="${coin }" var="coinNum" type="percent"/> </p>
	<p>coinNum : ${coinNum }</p>
</body>
</html>