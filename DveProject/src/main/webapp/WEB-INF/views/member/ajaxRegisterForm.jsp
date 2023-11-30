<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h1>9. Ajax 방식 요청 처리</h1>
	
	<h3>Ajax 요청 처리 방식</h3>
	
	<form>
		userId : <input type="text" name="userId" value="hongkd" id="userId" /><br/>
		password : <input type="text" name="password" value="1234" id="password" /><br/>
	</form>
	
	<p>1) URL 경로 상의 여러개의 경로 변수값을 @PathVarialble 어노테이션을 지정하여 여러개의 문자열 매개변수로 처리한다.</p>
	<button id="registerBtn01">Register01</button>
	
	<p>2) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.</p>
	<button id="registerBtn02">Register02</button>
	
	<p>3) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.</p>
	<button id="registerBtn03">RegisterBtn03</button>
	
	<p>4) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 @RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.</p>
	<button id="registerBtn04">RegisterBtn04</button>
	
	<p>5) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 어노테이션을 지정하여 처리한다.</p>
	<button id="registerBtn05">RegisterBtn05</button>
	
	<p>6) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<button id="registerBtn06">RegisterBtn06</button>
	
	<p>7) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다.</p>
	<button id="registerBtn07">RegisterBtn07</button>
	
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var registerBtn01 = $("#registerBtn01");
	var registerBtn02 = $("#registerBtn02");
	var registerBtn03 = $("#registerBtn03");
	var registerBtn04 = $("#registerBtn04");
	var registerBtn05 = $("#registerBtn05");
	var registerBtn06 = $("#registerBtn06");
	var registerBtn07 = $("#registerBtn07");
	
	// 1)
	registerBtn01.on("click",function(){
		
		$.ajax({
			type : "post",
			url : "/ajax/register/hongkd/pw01",
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
		
	});
	
	// 2)
	registerBtn02.on("click",function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		};
		
		$.ajax({
			type : "post",
			url : "/ajax/register02",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 3)
	registerBtn03.on("click",function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		};
		
		$.ajax({
			type : "post",
			url : "/ajax/register03",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
		
	});
	
	// 4)
	registerBtn04.on("click",function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password
		};
		
		$.ajax({
			type : "post",
			url : "/ajax/register04/hongkildong",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
		
	});
	
	// 5)
	registerBtn05.on("click",function(){
		var userObjectArray = [
			{
				userId : "name01",
				password : "pw01"
			},
			{
				userId : "name02",
				password : "pw02"
			}
		];
		
		$.ajax({
			type : "post",
			url : "/ajax/register05",
			data : JSON.stringify(userObjectArray),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	// 6)
	registerBtn06.on("click",function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password,
			address : {
				postCode : "010908",
				location : "Daejeon"
			}
		};
			
		
		$.ajax({
			type : "post",
			url : "/ajax/register06",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	registerBtn07.on("click",function(){
		var userId = $("#userId").val();
		var password = $("#password").val();
		
		var userObject = {
			userId : userId,
			password : password,
			cardList : [ 
				{
					no : "23456",
					validMonth : "20221018"
				},
				{
					no : "12342",
					validMonth : "20221017"
				}
			]
		};
			
		$.ajax({
			type : "post",
			url : "/ajax/register07",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	
	
});

</script>
</html>