<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="register-box">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<a href="" class="h1"><b>DDIT</b>BOARD</a>
		</div>
		<div class="card-body">
			<p class="login-box-msg">회원가입</p>

			<form action="/notice/signup.do" method="post" id="signupForm" enctype="Multipart/form-data">
				<div class="input-group mb-3 text-center">
					<img class="profile-user-img img-fluid img-circle" id="profileImg" src="/resources/dist/img/AdminLTELogo.png" alt="User profile picture" style="width: 150px;">
				</div>
				<div class="input-group mb-3">
					<label for="inputDescription">프로필 이미지</label>
				</div>
				<div class="input-group mb-3">
					<div class="custom-file">
						<input type="file" class="custom-file-input" name="imgFile" id="imgFile">
						<label class="custom-file-label" for="imgFile">프로필 이미지를 선택해주세요</label>
					</div>
				</div>
				<div class="input-group mb-3">
					<label for="inputDescription">프로필 정보</label>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memId" name="memId"	placeholder="아이디를 입력해주세요">
					<span class="input-group-append">
						<button type="button" class="btn btn-secondary btn-flat" id="idCheckBtn">중복확인</button>
					</span>
					<span class="error invalid-feedback" style="display: block;">${errors.memId }</span>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memPw" name="memPw"	placeholder="비밀번호를 입력해주세요">
					<span class="error invalid-feedback" style="display: block;">${errors.memPw }</span>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memName" name="memName" placeholder="이름을 입력해주세요">
					<span class="error invalid-feedback" style="display: block;">${errors.memName }</span>
				</div>
				<div class="input-group mb-3">
					<div class="form-group clearfix">
						<div class="icheck-primary d-inline">
							<input type="radio" id="memGenderM" name="memGender" value="M" checked="checked">
							<label for="memGenderM">남자</label>
						</div>
						<div class="icheck-primary d-inline">
							<input type="radio" id="memGenderF" name="memGender" value="F">
							<label for="memGenderF">여자</label>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memEmail" name="memEmail" placeholder="이메일을 입력해주세요">
					<span class="input-group-append">
						<button type="button" onclick="sendEmailCode()" class="btn btn-secondary btn-flat">이메일 인증</button>
					</span>
				</div>
				<div class="emailCodeBox" style="display: none;">
					<div class="input-group mb-3">
						<input type="text" class="form-control" id="emailCode" name="emailCode" placeholder="이메일 인증 코드를 입력하세요">
						<span class="input-group-append">
							<button type="button" onclick="emailCheck()" class="btn btn-secondary btn-flat">인증확인</button>
						</span>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memPhone" name="memPhone" placeholder="전화번호를 입력해주세요">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memPostCode" name="memPostCode">
					<span class="input-group-append">
						<button type="button" onclick="DaumPostcode()" class="btn btn-secondary btn-flat">우편번호 찾기</button>
					</span>
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memAddress1" name="memAddress1" placeholder="주소를 입력해주세요">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memAddress2" name="memAddress2" placeholder="상세주소를 입력해주세요">
				</div>
				<div class="row">
					<div class="col-8">
						<div class="icheck-primary">
							<input type="checkbox" id="memAgree" name="memAgree" value="Y">
							<label for="memAgree"> 개인정보 사용을 동의해주세요 <a href="#">개인정보방침</a></label>
						</div>
					</div>
					<div class="col-4">
						<button type="button" class="btn btn-primary btn-block" id="signupBtn">가입하기</button>
					</div>
				</div>
				<sec:csrfInput/>
			</form>
		</div>
	</div>
	<br />
	<div class="card card-outline card-secondary">
		<div class="card-header text-center">
			<h4>MAIN MENU</h4>
			<button type="button" class="btn btn-secondary btn-block"
				onclick="javascript:location.href='/notice/login.do'">뒤로가기</button>
		</div>
	</div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function() {
	var idCheckBtn = $("#idCheckBtn");
	var signupBtn = $("#signupBtn");
	var signupBtn = $("#signupBtn");
	var signupForm = $("#signupForm");
	var imgFile = $("#imgFile");
	var idCheckFlag = false;
	var emailFlag = false;

	idCheckBtn.on("click", function() {
		var id = $("#memId").val();

		if (id == null || id == "") {
			alert("아이디를 입력해주세요.");
			return false;
		}

		// 방법 2)
		// 보낼 data를 JSON.stringify()로 묶어서 json 객체로 데이터를 보내고
		// contentType : "application/json; charset=uft-8"
		// 위와 같은 설정으로 진행하면, request header 정보에
		// contentType은 json으로 넘어가고, payload는 json 객체 형식으로 데이터가 넘어감
		var data = {
			memId : id
		};

		$.ajax({
			type : "post",
			url : "/notice/idCheck.do",
			// 			data : {memId : id},			// 방법 1) contentType 설정 안함 / data도 {id : 1}과 같이 설정
			beforeSend : function(xhr){
				xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
			},
			data : JSON.stringify(data), // 방법 2)
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				console.log("아이디 중복 확인 결과 : " + res);
				if (res == "NOTEXIST") { // 아이디 사용 가능
					alert("사용가능한 아이디 입니다!");
					idCheckFlag = true; // 가입하기 버튼을 클릭할 때 아이디 중복 체크를 했는지 여부
				} else { // 아이디 사용 불가능
					alert("이미 사용중인 아이디입니다!");
				}
			}
		});
	});

	signupBtn.on("click", function() {
		var id = $("#memId").val();
		var pw = $("#memPw").val();
		var name = $("#memName").val();
		var agreeFlag = false;

		if (id == null || id == "") {
			alert("아이디를 입력해주세요.");
			return false;
		}

		if (pw == null || pw == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		}

		if (name == null || name == "") {
			alert("이름를 입력해주세요.");
			return false;
		}

		// 개인정보 처리 방침을 동의하게 되면 Y 값이 넘어오므로, 동의 여부는 true로 설정
		var agree = $("#memAgree:checked").val();
		if (agree == 'Y') {
			agreeFlag = true;
		}

		// 개인정보 처리 방침에 동의하셨습니까?
		if (agreeFlag) {
			// 아이디 중복 체크를 하고 오셨습니까?
			if (idCheckFlag) {
				// 이메일 인증을 하고 오셨습니까?
					signupForm.submit();
// 				if(emailFlag){
// 					signupForm.submit();
// 				}else{
// 					alert("이메일 인증을 진행해주세요!");
// 				}
			} else {
				alert("아이디 중복 체크를 진행해주세요!");
			}
		} else {
			alert("개인정보 동의를 체크해주세요!");
		}

	});

	imgFile.on("change", function(event) {
		var file = event.target.files[0];

		if (isImageFile(file)) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#profileImg").attr("src", e.target.result);
			}
			reader.readAsDataURL(file);
		} else {
			alert("이미지 파일을 선택해 주세요.");
		}
	});

});

// 이미지 파일인지 체크
function isImageFile(file) {
	var ext = file.name.split(".").pop().toLowerCase(); // 파일명에서 확장자를 꺼낸다
	return ($.inArray(ext, [ "jpg", "jpeg", "gif", "png" ]) === -1 ? false
			: true);
}

function DaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('memPostCode').value = data.zonecode;
			document.getElementById("memAddress1").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("memAddress2").focus();
		}
	}).open();
}

// 이메일 코드 전송
function sendEmailCode(){
	var email = $("#memEmail").val();
	
	if (email == null || email == "") {
		alert("이메일을 입력해주세요.");
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : "/email/sendEmailCode",
		data : email,
		contentType : "application/json; charset=utf-8",
		success : function(result){
			if(result == "OK"){
				$(".emailCodeBox").css("display", "block");
				alert("이메일로 인증 코드를 전송하였습니다. 이메일을 확인하여주세요.");
			}else{
				alert("서버오류, 다시 시도해주세요!");
			}
		}
	});
}

// 이메일 인증 코드 인증
function emailCheck(){
	var email = $("#memEmail").val();
	var code = $("#emailCode").val();
	
	if (code == null || code == "") {
		alert("인증코드를 입력해주세요.");
		return false;
	}
	
// 	var data = {
// 		email : email,
// 		code : code
// 	};

	console.log(code);
	
	$.ajax({
		type : "POST",
		url : "/email/emailCheck",
// 		data : JSON.stringify(data),
		data : code,
		contentType : "application/json; charset=utf-8",
		success : function(result){
			if(result == "OK"){
				alert("이메일 인증이 완료되었습니다. 회원가입을 진행하세요.");
				emailFlag = true;
			}else{
				alert("인증 코드가 올바르지 않습니다. 다시 확인하세요.");
			}
		}
	});
}
</script>