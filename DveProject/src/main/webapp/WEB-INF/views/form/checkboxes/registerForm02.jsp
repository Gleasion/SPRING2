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
	<h3>Spring Form Tag</h3>
	<p>2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.</p>
	<form:form method="post" action="/formtag/register" modelAttribute="member">
		<table>
			<tr>
				<td>취미(hobbyList)</td>
				<td>
					<form:checkboxes path="hobbyList" items="${hobbyCodeList }" itemLabel="label" itemValue="value" /><br/>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>