<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register All Result</title>
</head>
<body>
<!-- 
	[아래 결과처럼 출력해주세요.]
	
	유저ID			a001
	패스워드			1234
	이름				조현준
	E-MAIL			wh-guswns123@hanmail.net
	생년월일			2023년 08월 25일
	성별				남자
	개발자여부			개발자
	외국인여부			외국인
	국적				대한민국
	소유차량			소유차량 없음
	취미				운동 영화시청
	우편번호			45617
	주소				대전광역시 서구  오류동
	카드1(번호)		1451-1234-1234-1122
	카드1(유효년월)	2040년 09월 09일
	카드2(번호)		1234-1234-1234-1234
	카드2(유효년월)	2040년 09월 09일
	소개				반갑습니다
	
	** 조건
	- 선택한 성별에 따라 남자/여자/기타로 나타내주세요.
	- 개발자 여부 체크에 따라 개발자/일반으로 나타내주세요.
	- 외국인 여부 체크에 따라 외국인/내국인으로 나타내주세요.
	- 국적에 따라 대한민국/독일/호주/캐나다로 나타내주세요.
	- 소유차량 선택에 따라 소유차량 없음/JEEP/VOLVO/BMW/AUDI로 나타내주세요.
		선택 갯수에 따라 아래처럼 출력해주세요.
		> 소유차량 없음
		> JEEP
		> JEEP VOLVO AUDI
	- 취미 선택에 따라 운동/영화시청/음악감상로 나타내주세요.
		선택 갯수에 따라 아래처럼 출력해주세요.
		> 취미 없음
		> 음악감상
		> 운동 영화시청

 -->
 	<h2>Register All Result</h2>
 	<table border="1px">
 		<tr>
 			<th>유저ID</th>
 			<td>${member.userId }</td>
 		</tr>
 		<tr>
			<th>패스워드</th>
			<td>${member.password }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<th>E-MAIL</th>
			<td>${member.email }</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><fmt:formatDate value="${member.dateOfBirth }" type="date" pattern="yyyy년 MM월 dd일"/></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${member.gender }</td>
		</tr>
		<tr>
			<th>개발자여부</th>
			<td>${member.developer }</td>
		</tr>
		<tr>
			<th>외국인여부</th>
			<td>
				<c:choose>
					<c:when test="${member.foreigner }">외국인</c:when>
					<c:otherwise>내국인</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>국적</th>
			<td>${member.nationality }</td>
		</tr>
		<tr>
			<th>소유차량</th>
			<td>${member.cars }</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>${member.hobby }</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>${member.address.postCode }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${member.address.location }</td>
		</tr>
		<tr>
			<th>카드1(번호)</th>
			<td>${member.cardList[0].no }</td>
		</tr>
		<tr>
			<th>카드1(유효년월)</th>
			<td><fmt:formatDate value="${member.cardList[0].validMonth }" type="date" pattern="yyyy년 MM월 dd일" /></td>
		</tr>
		<tr>
			<th>카드2(번호)</th>
			<td>${member.cardList[1].no }</td>
		</tr>
		<tr>
			<th>카드2(유효년월)</th>
			<td><fmt:formatDate value="${member.cardList[1].validMonth }" type="date" pattern="yyyy년 MM월 dd일" /></td>
		</tr>
		<tr>
			<th>소개</th>
			<td>${member.introduction }</td>
		</tr>
			
 	</table>

</body>
</html>