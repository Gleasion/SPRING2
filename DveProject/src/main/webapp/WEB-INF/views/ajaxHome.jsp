<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var putBtn = $("#putBtn");
	var putHeaderBtn = $("#putHeaderBtn");
	var postBtn = $("#postBtn");
	var putJsonBtn = $("#putJsonBtn");
	var putXmlBtn = $("#putXmlBtn");
	var getBtn = $("#getBtn");
	var getJsonBtn = $("#getJsonBtn");
	var getXmlBtn = $("#getXmlBtn");
	
	
	putBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNo,
			title : title,
			content : content,
			writer : writer
		};
		
		$.ajax({
			type: "put",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				// "==" Equals Operator, "===" Strict Equals Operator로 "==="는  값을 더 엄격하게 비교할 때 사용한다.
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putHeaderBtn.on("click",function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNo,
			title : title,
			content : content,
			writer : writer
		};
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			headers :{
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
		
	postBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNo,
			title : title,
			content : content,
			writer : writer
		};
		
		$.ajax({
			type : "post",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putJsonBtn.on("click",function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
			boardNo : boardNo,
			title : title,
			content : content,
			writer : writer
		};
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putXmlBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var xmlData = "<Board>";
		xmlData += "<boardNo>" + boardNo + "</boardNo>";
		xmlData += "<title>" + title + "</title>";
		xmlData += "<content>" + content + "</content>";
		xmlData += "<writer>" + writer + "</writer>";
		xmlData += "<regDate>2018-12-10</regDate>";
		xmlData += "</Board>";
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNo,
			data : xmlData,
			contentType : "application/xml; charset=utf-8",
			success : function(result){
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
		
	});
	
	getBtn.on("click", function() {
		var boardNo = $("#boardNo").val();
		
		console.log(boardNo);
		
		//GET 방식 비동기 HTTP 요청 수행
		$.get("/board/" + boardNo, function(data) {
		   console.log(data);
		   alert(JSON.stringify(data));
		});
	});
	
	getJsonBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNo,
			// 요청의 Accept 해더 값을 "application/json" 미디어 타입으로 지정한다.
			headers : {
				"Accept" : "application/json"
			},
			success : function(result){
				console.log(result);
				alert(JSON.stringify(result));
			}
		});
	});
	
	getXmlBtn.on("click",function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNo,
			headers : {
				"Accept" : "application/xml"
			},
			success : function(result){
				console.log(result);
				alert(xmlToString(result));
			}
		});
		
	});
	
});

function xmlToString(xmlData){
	var xmlString;
	
	// xml 데이터를 출력할 때 브라우저마다 출력 엔진들이 조금씩 다르다
	// window.ActiveXObjext는 AvticeXObject를 지원하는 브라우저면 Obejct를 리턴하고 그렇지 않은 경우 null을 리턴
	if(window.ActiveXObject){		// IE기반 및 타브라우저 하위 버전
		xmlString = xmlData.xml;
	}else{
		// 파싱된 XML 데이터를 String으로 변환
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}
</script>
<body>
	<h1>Ajax Home</h1>
	
	<form>
		<p>boardNo : <input type="text" name="boardNo" value="" id="boardNo" /></p>
		<p>title : <input type="text" name="title" value="" id="title" /></p>
		<p>content : <input type="text" name="content" value="" id="content" /></p>
		<p>writer : <input type="text" name="writer" value="" id="writer" /></p>
	</form>
	
	<div>
		<button id="putBtn">MODIFY(PUT)</button>
		<button id="putHeaderBtn">MODIFY(PUT with Header)</button>
		
		<button id="postBtn">MODIFY(POST)</button>
		<button id="putJsonBtn">MODIFY(Put Json)</button>
		<button id="putXmlBtn">MODIFY(Put Xml)</button>
		
		<button id="getBtn">READ</button>
		<button id="getJsonBtn">READ(JSON)</button>
		<button id="getXmlBtn">READ(XML)</button>
	</div>
</body>
</html>