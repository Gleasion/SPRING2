<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<p>3) pattern 속성을 사용하여 직접 사용할 서식을 지정한다.</p>
	<p>coin : ${coin }</p>
	<p><fmt:parseNumber value="${coin }" var="coinNum" pattern="0,000.00"/> </p>
	<p>coinNum : ${coinNum }</p>
	<!-- 
		parseNumber는 설정된 포맷 문자열을 pattern 속성과 일치시켜 숫자로 변환한다.
		parseNumber는 설정된 포맷 문자열을 type 속성과 일치시켜 숫자로 변환한다.
			- currency 일때는 통화기호가 포함된 문자열을 파싱
			- percent 일때는 %가 포함된 문자열을 파싱
	 -->
	
</body>
</html>