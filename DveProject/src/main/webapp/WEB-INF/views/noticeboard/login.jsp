<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<div class="login-box">
	<div class="login-logo">
		<a href=""><b>DDIT</b>BOARD</a>
	</div>
	<div class="card">
		<div class="card-body login-card-body">
			<p class="login-box-msg">로그인을 진행해주세요</p>

			<form action="/login" method="post" id="signForm">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="memId" name="username" placeholder="아이디를 입력해주세요">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
					<span class="error invalid-feedback" style="display:block;">${errors.memId }</span>
				</div>
				<div class="input-group mb-3">
					<input type="password" class="form-control"	id="memPw" name="password" placeholder="비밀번호를 입력해주세요">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
					<span class="error invalid-feedback" style="display:block;">${errors.memPw }</span>
				</div>
				<div class="row">
					<div class="col-8">
						<div class="icheck-primary"></div>
					</div>
					<div class="col-4">
						<button type="button" class="btn btn-primary btn-block" id="loginBtn" >로그인</button>
					</div>
				</div>
				<sec:csrfInput/>
			</form>

			<p class="mb-1">
				<a href="/notice/forget.do">아이디 & 비밀번호 찾기</a>
			</p>
			<p class="mb-1">
				<a href="/email/findemail.do">이메일로 아이디 & 비밀번호 찾기</a>
			</p>
			<p class="mb-0">
				<a href="/notice/signup.do" class="text-center">회원가입</a>
			</p>
		</div>
	</div>
</div>
<script>
$(function(){
	var signForm = $("#signForm");
	var loginBtn = $("#loginBtn");
	
	var id = $("#memId");
	var pw = $("#memPw");
	
	console.log(id);
	console.log(pw);
	
	loginBtn.on("click", function(){
		var id = $("#memId");
		var pw = $("#memPw");
		
		console.log(id);
		console.log(pw);
		
// 		if(id == null || id == ""){
// 			alert("아이디를 입력해주세요.");
// 			return false;
// 		}
		
// 		if(pw == null || pw == ""){
// 			alert("비밀번호를 입력해주세요.");
// 			return false;
// 		}
		
		signForm.submit();
	});
	
	
	
	
});
</script>