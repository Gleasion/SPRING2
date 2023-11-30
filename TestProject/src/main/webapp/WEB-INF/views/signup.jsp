<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="page-header min-vh-100">
	<div class="container">
		<div class="row">
			<div class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
				<div class="position-relative bg-gradient-info h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center"
					style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/illustrations/illustration-lock.jpg'); background-size: cover;">
				</div>
			</div>
			<div
				class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
				<div class="card card-plain">
					<div class="card-header">
						<h4 class="font-weight-bolder">회원가입</h4>
						<p class="mb-0">회원등록 후, 저희 서비스와 함께해요!</p>
					</div>
					<div class="card-body">
						<form role="form" method="post" action="/signup.do" id="signupForm">
							<font class="font-weight-bold text-xs mt-1 mb-0 error"><!-- 아이디 에러처리 --></font>
							<div class="input-group input-group-outline mb-3">
								<input type="text" class="form-control" id="memId" name="memId" placeholder="아이디">
							</div>
							<font class="text-primary font-weight-bold text-xs mt-1 mb-0 error"><!-- 비밀번호 에러처리 --></font>
							<div class="input-group input-group-outline mb-3">
								<input type="text" class="form-control" id="memPw" name="memPw" placeholder="비밀번호">
							</div>
							<div class="input-group input-group-outline mb-3">
								<input type="text" class="form-control" id="memPwRe" placeholder="비밀번호 재입력">
							</div>
							<font class="text-primary font-weight-bold text-xs mt-1 mb-0 error"><!-- 이름 에러처리 --></font>
							<div class="input-group input-group-outline mb-3">
								<input type="text" class="form-control" id="memName" name="memName" placeholder="이름">
							</div>
							<font class="font-weight-bold text-xs mt-1 mb-0 error"><!-- 닉네임 에러처리 --></font>
							<div class="input-group input-group-outline mb-3">
								<input type="text" class="form-control" id="memNickname" name="memNickname" placeholder="닉네임">
								<input type="button" class="form-control" id="nickChkBtn" value="중복확인"/>
							</div>
							<div class="form-check form-switch">
								<input class="form-check-input" type="checkbox" id="agree" value="Y"> 
								<label class="form-check-label" for="agree">개인정보 동의</label>
							</div>
							<font class="text-primary font-weight-bold text-xs mt-1 mb-0 error"></font>
							<div class="text-center">
								<button type="button" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0" id="signupBtn">가입하기</button>
							</div>
						</form>
					</div>
					<div class="card-footer text-center pt-0 px-lg-2 px-1">
						<p class="mb-2 text-sm mx-auto">
							우리 서비스 회원이세요? 
							<a href="/signin.do" class="text-primary text-gradient font-weight-bold">로그인</a>
						</p>
						<font class="text-primary font-weight-bold text-xs mt-1 mb-0 error"><!-- 가입하기 에러처리 --></font>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>