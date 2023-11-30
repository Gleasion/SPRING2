<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="login-box">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p class="h4">
				<b>아이디찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">아이디 찾기는 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post" id="idFindForm">
				<div class="input-group mb-3">
					<input type="text" class="form-control" name="memEmail" id="memEmail" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" name="memName" id="memName" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p>
						회원님의 아이디는 [<font id="id" color="red" class="h2 text-danger"></font>] 입니다.
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" class="btn btn-primary btn-block" id="idFindBtn">아이디찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br />
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p href="" class="h4">
				<b>비밀번호찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">비밀번호 찾기는 아이디, 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memId" name="memId" placeholder="아이디를 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memEmail2" name="memEmail2" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memName2" name="memName2" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p>
						회원님의 비밀번호는 [<font color="red" class="h2 text-danger" id="password"></font>] 입니다.
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" class="btn btn-primary btn-block" id="pwFindBtn">비밀번호찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br/>
	<div class="card card-outline card-secondary">
		<div class="card-header text-center">
			<h4>MAIN MENU</h4>
			<button type="button" class="btn btn-secondary btn-block" id="loginBtn">로그인</button>
		</div>
	</div>
</div>
<script>
$(function(){
	var loginBtn = $("#loginBtn");
	var idFindBtn = $("#idFindBtn");
	var loginBtn = $("#loginBtn");
	var pwFindBtn = $("#pwFindBtn");
	
	loginBtn.on("click",function(){
		location.href = "/notice/login.do";
	});
	
	// 아이디를 찾기 버튼
	idFindBtn.on("click", function(){
		var email = $("#memEmail").val();
		var name = $("#memName").val();
		
		var data = {
			memName : name,
			memEmail : email
		};
		
		if(email == null || email == ""){
			alert("이메일을 입력해주세요.");
			$("#memEmail").focus();
			return false;			
		}
		
		if(name == null || name == ""){
			alert("이름을 입력해주세요.");
			$("#memName").focus();
			return false;			
		}
		
		$.ajax({
			type : "post",
			url : "/notice/idFind.do",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				console.log("아이디 찾기 결과 : " + res);
				if(res == "" || res == null){
					alert("정보와 일치하는 회원정보가 존재하지 않습니다.");
				}else{
					$("#id").html(res);
				}
			}
		});
	});
	
	// 비밀번호 찾기 버튼
	pwFindBtn.on("click", function(){
		var id = $("#memId").val();
		var email = $("#memEmail2").val();
		var name = $("#memName2").val();
		
		var data = {
			memId : id,
			memName : name,
			memEmail : email
		};
		
		if(id == null || id == ""){
			alert("아이디를 입력해주세요.");
			$("#memId").focus();
			return false;			
		}
		
		if(email == null || email == ""){
			alert("이메일을 입력해주세요.");
			$("#memEmail2").focus();
			return false;			
		}
		
		if(name == null || name == ""){
			alert("이름을 입력해주세요.");
			$("#memName2").focus();
			return false;			
		}
		
		$.ajax({
			type : "post",
			url : "/notice/pwFind.do",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				console.log("비밀번호 찾기 결과 : " + res);
				if(res == "" || res == null){
					alert("정보와 일치하는 회원정보가 존재하지 않습니다.");
				}else{
					$("#password").html(res);
				}
			}
		});
	});
	
});

</script>






