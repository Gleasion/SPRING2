<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER FORM</title>
</head>
<body>
	<h3>Register Form</h3>
	
	<h4>1. 컨트롤러 메소드 매개변수(요청처리)</h4>
	<hr/>
	<p>1) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.</p>
	<a href="/register?userId=hongkd&password=1234">Register01</a>
	
	<p>2) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.</p>
	<a href="/register/hongkd">Register02</a><br/>
	
	<p>3) HTML Form 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</p>
	<form action="/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<p>4) HTML 폼 필드가 여러개일 경우에 컨트롤러 매개변수의 위치는 상관 없다.</p>
	<form action="/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<p>5) HTML Form 필드값이 숫장리 경우에는 컨드롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.</p>
	<form action="/register03" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<br/>
	
	<h4>3. 요청 데이터 처리 어노테이션</h4>
	<hr/>
	
	<p>1) URL 경로 상의 경로 변수가 여러개일 경우, @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.</p>
	<a href="/register/hongkd/100">RegisterAnnotation</a>
	
	<p>2) HTML Form 필드명과 컨트롤러 매개변수명이 일치(대소문자 구분)하지 않으면 요청을 처리할 수 없다.</p>
	<form action="/register0201" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<p>3) @RequestParam 어노테이션을 사용하여 특정한 HTML From의 필드명을 지정하여 요청을 처리한다.</p>
	<form action="/register0202" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<br/>
	
	<h4>4. 요청 처리 자바빈즈</h4>
	<hr/>
	
	<p>1) 폼 텍스트 필드 요소값을 자바 빈즈 매개변수로 처리한다.</p>
	<form action="/beans/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<p>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.</p>
	<form action="/beans/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		coin : <input type="text" name="coin" value="100" />
		<input type="submit" value="전송" />
	</form>
	
	<br/>
	
	<h4>5. Date 타입 처리</h4>
	<hr/>
	
	<p>1) 쿼리 파라미터(dataOfBirth=1234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=1234">RegisterGet01</a>
	<font color="red">400-Bad Request 에러 발생</font><br/>
	<br/>
	
	<p>2) 쿼리 파라미터(dataOfBirth=2018-09-08)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2018-09-08">RegisterGet02</a>
	<font color="red">400-Bad Request 에러 발생</font><br/>
	<br/>
	
	<p>3) 쿼리 파라미터(dataOfBirth=20180908)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=20180908">RegisterGet03</a>
	<font color="red">400-Bad Request 에러 발생</font><br/>
	<br/>
	
	<p>4) 쿼리 파라미터(dataOfBirth=2018/09/08)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2018/09/08">RegisterGet04</a>
	<font color="red">SUCCESS</font><br/>
	<br/>
	
	<p>5) Member 매개변수와 쿼리 파라미터(dataOfBirth=20180908)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환에 실패한다.</p>
	<a href="/registerByGet02?userId=hongkd&dateOfBirth=20180908">RegisterGet05</a>
	<font color="red">400-Bad Request 에러 발생</font><br/>
	<br/>
	
	<p>6) 직접 데이터를 활용해서 받기 </p>
	<form action="/register" method="post">
		userId : <input type="text" name="userId" value="hongkd" />
		password : <input type="text" name="password" value="1234" />
		dateOfBirth : <input type="text" name="dateOfBirth" value="" />
		<input type="submit" value="전송" />
	</form>
	
	<br/>
	
	<h4>7. 폼 방식 요청 처리</h4>
	<hr/>
	
	<p>1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerUserId" method="post">
		userId : <input type="text" name="userId" />
		<input type="submit" value="전송" /><br/>
	</form><br/>
	
	<p>2) 폼 텍스트 필드 요소값을 자바 빈즈 매개변수로 처리한다.</p>
	<form action="/registerMemberUserId" method="post">
		userId : <input type="text" name="userId" />
		<input type="submit" value="전송" /><br/>
	</form><br/>
	
	<p>3) 폼  비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerPassword" method="post">
		password : <input type="text" name="password" />
		<input type="submit" value="전송" /><br/>
	</form><br/>
	
	
	<p>4) 폼 라디오 버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerRadio" method="post">
		gender : <br/>
		<input type="radio" name="gender" value="male" checked="checked" />Male<br/>
		<input type="radio" name="gender" value="female" />Female<br/>
		<input type="radio" name="gender" value="other" />Other<br/>
		<input type="submit" value="전송" />
	</form>
	
	<p>5) 폼 셀렉트박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerSelect" method="post">
		nationality : <br/>
		<select name="nationality">
			<option value="Korea">대한민국</option>
			<option value="Germany">독일</option>
			<option value="Austrailia">호주</option>
			<option value="Canada">캐나다</option>
		</select>
		<input type="submit" value="전송"/>
	</form><br/>
	
	<p>6) 복수 선택이 가능한 폼 셀렉트박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerMultipleSelect01" method="post">
		cars : <br/>
		<select name="cars" multiple="multiple">
			<option value="Jeep">JEEP</option>
			<option value="Bmw">BMW</option>
			<option value="Audi">AUDI</option>
			<option value="Volvo">VOLVO</option>
		</select>
		<input type="submit" value="전송"/>
	</form><br/>
	
	<p>7) 복수 선택이 가능한 폼 셀렉트박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</p>
	<form action="/registerMultipleSelect02" method="post">
		carArray : <br/>
		<select name="carArray" multiple="multiple">
			<option value="Jeep">JEEP</option>
			<option value="Bmw">BMW</option>
			<option value="Audi">AUDI</option>
			<option value="Volvo">VOLVO</option>
		</select>
		<input type="submit" value="전송"/>
	</form><br/>
	
	<p>8) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 요소를 가진 리스트 타입 매개변수로 처리한다.</p>
	<form action="/registerMultipleSelect03" method="post">
		carList : <br/>
		<select name="carList" multiple="multiple">
			<option value="Jeep">JEEP</option>
			<option value="Bmw">BMW</option>
			<option value="Audi">AUDI</option>
			<option value="Volvo">VOLVO</option>
		</select>
		<input type="submit" value="전송"/>
	</form><br/>
	<font color="red">List로는 SelectBox의 값을 얻어올 수 없음</font><br/>
	
	<p>9) 폼 체크박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox01" method="post">
		hobby : <br/>
		<input type="checkbox" name="hobby" value="Sports" />Sports<br/>
		<input type="checkbox" name="hobby" value="Music" />Music<br/>
		<input type="checkbox" name="hobby" value="Movie" />Movie<br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>10) 폼 체크박스 요소 값을 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox02" method="post">
		hobbyArray : <br/>
		<input type="checkbox" name="hobbyArray" value="Sports" />Sports<br/>
		<input type="checkbox" name="hobbyArray" value="Music" />Music<br/>
		<input type="checkbox" name="hobbyArray" value="Movie" />Movie<br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>11) 폼 체크박스 요소 값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox03" method="post">
		hobbyList : <br/>
		<input type="checkbox" name="hobbyList" value="Sports" />Sports<br/>
		<input type="checkbox" name="hobbyList" value="Music" />Music<br/>
		<input type="checkbox" name="hobbyList" value="Movie" />Movie<br/>
		<input type="submit" value="전송" />
	</form><br/>
	<font color="red">List로는 Checkbox의 값을 얻어올 수 없음</font><br/>
	
	<p>12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 매개변수로 처리한다.</p>
	<form action="/registerCheckbox04" method="post">
		developer : <br/>
		<input type="checkbox" name="developer" value="Y" />개발자 여부<br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>13) 폼 체크박스 요소값을 기본 데이터 타입인 블리언 타입 매개변수로 처리한다.</p>
	<form action="/registerCheckbox05" method="post">
		foreigner : <br/>
		<input type="checkbox" name="foreigner" value="true" />외국인 여부<br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerAddress" method="post">
		postCode : <input type="text" name="postCode"><br/>
		location : <input type="text" name="location"><br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerUserAddress" method="post">
		postCode : <input type="text" name="address.postCode"><br/>
		location : <input type="text" name="address.location"><br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>16) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerUserCardList" method="post">
		카드1 - 번호 : <input type="text" name="cardList[0].no"><br/>
		카드1 - 유효년월 : <input type="text" name="cardList[0].validMonth"><br/>
		카드2 - 번호 : <input type="text" name="cardList[1].no"><br/>
		카드2 - 유효년월 : <input type="text" name="cardList[1].validMonth"><br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>17) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
	<form action="/registerTextArea" method="post">
		introduction : <br/>
		<textarea rows="6" cols="50" name="introduction"></textarea>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>18 폼 텍스트 영역 요소값을 Date 타입 매개변수로 처리한다.</p>
	<form action="/registerDate01" method="post">
		dateOfBirth : <input type="text" name="dateOfBirth" /><br/>
		<input type="submit" value="전송" />
	</form><br/>
	
	<p>19) 폼 텍스트 영역 요소값을 @DateTimeFormat 어노테이션을 지정하여 Date 타입 매개변수로 처리한다.</p>
	<form action="/registerDate02" method="post">
		dateOfBirth : <input type="text" name="dateOfBirth" /><br/>
		<input type="submit" value="전송" />
	</form><br/>
	

	<!-- 8. 파일 업로드 폼 방식 요청 처리 -->
	<h3>8. 파일 업로드 폼 방식 요청 처리</h3>
	<hr/>
	
	<p>1) 파일업로드 폼 파일 요소 값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</p>
	<form action="/registerFile01" method="post" enctype="multipart/form-data">
		<input type="file" name="picture"/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>2) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 문자열 매개변수로 처리한다.</p>
	<form action="/registerFile02" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="picture"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>3) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile03" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="picture"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>4) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile04" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="picture"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>5) 여러개의 파일 업로드 폼 파일 요소값을 MultipartFile 매개변수로 처리한다.</p>
	<form action="/registerFile05" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="picture"/><br/>
		<input type="file" name="picture2"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>6) 여러개의 파일업로드를 폼 파일 요소 값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
	<form action="/registerFile06" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="pictureList[0]"/><br/>
		<input type="file" name="pictureList[1]"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<font color="red">List로는 여러개의 이미지파일의 값을 얻어올 수 없음</font><br/>
	
	<p>7) 여러개의 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiFileMember 타입의 자바 빈즈 매개변수로 처리한다.</p>
	<form action="/registerFile07" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="pictureList[0]"/><br/>
		<input type="file" name="pictureList[1]"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	<p>8) 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다.</p>
	<form action="/registerFile08" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="file" name="pictureList" multiple="multiple"/><br/>
		<input type="submit" value="전송"/>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>