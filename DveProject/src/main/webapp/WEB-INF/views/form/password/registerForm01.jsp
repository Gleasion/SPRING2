<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Tag</title>
</head>
<!-- 
	path 속성에 설정된 속성값이 id, name으로 설정되고
	비밀번호는 modelAttribute에 설정된 member 자바빈즈 클래스 내 매개변수에 값이 존재한다 하더라도
	비밀번호는 value 속성에 값으로 전달되지 않는다.
 -->
<body>
	<h2>Spring Form Tag</h2>
	<form:form method="post" action="/formtag/register" modelAttribute="member">
		<table>
			<tr>
				<td>비밀번호</td>
				<td>
					<form:password path="password"/>
					<font color="red">
						<form:errors path="password"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>