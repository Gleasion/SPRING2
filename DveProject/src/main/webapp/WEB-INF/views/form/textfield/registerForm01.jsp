<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Tag</title>
</head>
<body>
	<h2>Spring Form Tag</h2>
	<p>1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.</p>
	<!-- 
		form:input의 path를 지정하면, id와 name을 path에 설정한 값으로 지정되고,
		modelAttribute 속성에 설정된 값과 컨트롤러 메소드의 순환체계가 연결되어있는 상태라면
		넘겨받은 member의 각 매개변수인 userId, userName, email의 값으로 value를 구성한다.
	 -->
	<form:form action="/formtag/register" method="post" modelAttribute="member">
		<table>
			<tr>
				<td>유저 ID</td>
				<td>
					<form:input path="userId" />
					<font color="red">
						<form:errors path="userId" />
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName" />
					<font color="red">
						<form:errors path="userName" />
					</font>
				</td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td>
					<form:input path="email" />
					<font color="red">
						<form:errors path="email" />
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>