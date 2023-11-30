<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read02</title>
</head>
<body>
	<h3>2) Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 뷰에서 참조할 이름을 클래스명의 앞 글자를 소문자로 변환하여 처리한다.</h3>

	<p>Result</p>
	member.userId : ${member.userId }<br/>
	member.password : ${member.password }<br/>
	member.userName : ${member.userName }<br/>
	member.email : ${member.email }<br/>
	member.birthDay : ${member.birthDay }<br/>
	member.dateOfBirth : ${member.dateOfBirth }<br/>
</body>
</html>