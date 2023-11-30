<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHHO EMAIL FORM</title>
</head>
<body>
<form action="/email/sendmail" method="post" enctype="multipart/form-data">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="subject" size="40">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<textarea name="body" rows="10" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<td>파일첨부</td>
			<td>
				<input type="file" name="attachment">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="submit" value="Submit">
			</td>
		</tr>
	</table>
</form>
</body>
</html>