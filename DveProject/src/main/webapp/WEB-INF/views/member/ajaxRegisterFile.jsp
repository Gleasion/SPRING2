<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<body>
	<h1>10. 파일 업로드 Ajax 방식 요청 처리</h1>
	<hr/>
	
	<p>Ajax 방식으로 전달할 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</p>
	<div>
		<input type="file" id="inputFile" /><br/>
		<hr/>
		<img id="preView" />
	</div>
</body>
<script type="text/javascript">
$(function(){
	var inputFile = $("#inputFile");
	
	// Ajax 방식으로 전달할 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.
	inputFile.on("change",function(event){
		var files = event.target.files;
		var file = files[0];
		
		console.log(file);
		
		if(isImageFile(file)){
			// ajax로 파일을 컨트롤 할 때에는 formData를 이용
			// append()를 이용하여 추가하고자 하는 파일 데이터를 key, value형식으로 넣는다.
			// 일반데이터도 마찬가지로 append()를 이용해서 추가하고 하는 데이터를 key, value 형식으로 넣는다.
			var formData = new FormData();
			formData.append("file", file);
			
			// formData는 key/value 형식으로 데이터가 저장
			// dataType : 응답(response)데이터를 내보낼 때 보내줄 데이터 타입
			// processData : 데이터 파라미터를 data라는 속성으로 넣는데, 제이쿼리 내부적으로 쿼리스트링을 구성
			//				파일 전송의 경우 쿼리스트링을 사용하지 않으므로 해당 설정을 false
			// contentType : Content-Type을 설정시 사용하는 해당 설정의 기본값은 "application/x-ww-form-urlencoded; charset=utf-8"
			//				-> 기본값으로 나가지 않고 "multipart/form-data"로 나갈 수 있도록 설정을 false함
			// request 요청에서 Content-Type을 확인해보면 "multipart/form-data; boundary=----WebKitFormBoundary7Ydjpu8j8iHJlkkjkkUhkb..."
			// 와 같은 값으로 전송된것을 확인할 수 있음
			$.ajax({
				type : "post",
				url : "/ajax/uploadAjax",
				data : formData,
				processData : false,
				contentType : false,
				dataType : "text",
				success : function(result){
					alert(result);
					
					if(result === "UPLOAD SUCCESS"){
						var file = event.target.files[0];
						var reader = new FileReader();
						reader.onload = function(e){
							// src에 경로를 세팅
							$("#preView").attr("src", e.target.result);
						}
						reader.readAsDataURL(file);
						// 최종 이미지가 출력되면, 이미지는 경로가 출력되지만 실제로는
						// base64 인코딩 설정에 의한 이미지 데이터가 출력된다.
					}
				}
			});
		}else{
			alert("이미지를 넣어주세요.");
		}
	});
});

function isImageFile(file){
	var ext = file.name.split(".").pop().toLowerCase();	// 파일명에서 확장자 가져오기
	// 확장자 중 이미지에 해당하는 확장자가 아닌경우 포함되어 있는 문자가 없으니까 -1(false)가 된다.
	// 이미지 확장자가 포함되어 있다면 0보다 큰 수 일테니 true
	return ($.inArray(ext, ["jpg", "jpeg", "gif", "png"]) === -1) ? false : true;
}
</script>
</html>