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
	<p>JSP에서 사용될 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시</p>

	<!-- 
		EL에서 발생한 에러가 아니라, 자바식에서 발생한 에러정보이기 때문에 var 속성에 담긴 에러정보를 확인 할 수 있다.
	 -->
	
	<%
		String[] hobbyArray = {"Music", "Movie"};
	%>
	<c:catch var = "ex">
		<%=hobbyArray[3] %>
	</c:catch>
	
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>
	</p>
	
</body>
</html>