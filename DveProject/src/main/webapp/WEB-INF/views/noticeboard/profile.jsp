<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER PROFILE</title>
</head>
<body>
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>Profile</h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item active">User Profile</li>
				</ol>
			</div>
		</div>
	</div>
</section>
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<div class="card card-primary card-outline">
					<div class="card-body box-profile">
						<div class="text-center">
							<img class="profile-user-img img-fluid img-circle" src="${member.memProfileImg }" alt="User profile picture">
						</div>
						<h3 class="profile-username text-center">${member.memName }</h3>
						<p class="text-muted text-center">${member.memRegDate }</p>
						<br />
						<p class="text-muted text-center">작성한 게시물</p>
						<ul class="list-group list-group-unbordered mb-3">
							<li class="list-group-item">
								<b>공지사항</b>
								<a class="float-right">356</a>
							</li>
							<li class="list-group-item">
								<b>자유게시판</b>
								<a class="float-right">150</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-header p-2">
						<ul class="nav nav-pills">
							<li class="nav-item">
								<a class="nav-link active" href="#settings" data-toggle="tab">내정보</a>
							</li>
						</ul>
					</div>
					<div class="card-body">
						<div class="tab-content">
							<div class="tab-pane active" id="settings">
								<form class="form-horizontal" action="/notice/profileUpdate.do" method="post" id="profileForm" enctype="multipart/form-data">
									<input type="hidden" name="memNo" id="memNo" value="${member.memNo }" />
									<div class="form-group row">
										<label for="memProfileImg" class="col-sm-2 col-form-label">프로필이미지</label>
										<div class="text-center">
											<img class="profile-user-img img-fluid img-circle" src="${member.memProfileImg }" id="profileImg" alt="User" style="width: 150px;">
										</div>
									</div>
									<div class="form-group row">
										<label for="memProfileImg" class="col-sm-2 col-form-label"></label>
										<div class="col-md-10">
										<br/>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="imgFile" name="imgFile">
											<label class="custom-file-label" for="imgFile">프로필 이미지를 선택해주세요</label>
										</div>
										</div>
									</div>
									<div class="form-group row">
										<label for="memId" class="col-sm-2 col-form-label">아이디</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="memId" name="memId" value="${member.memId }" placeholder="아이디를 입력해주세요." disabled="disabled">
										</div>
									</div>
									<div class="form-group row">
										<label for="memPw" class="col-sm-2 col-form-label">비밀번호</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="memPw" name="memPw" value="${member.memPw }" placeholder="비밀번호를 입력해주세요.">
										</div>
									</div>
									<div class="form-group row">
										<label for="memName" class="col-sm-2 col-form-label">이름</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="memName" name="memName" value="${member.memName }" placeholder="이름을 입력해주세요.">
										</div>
									</div>
									<div class="form-group row">
										<label for="" class="col-sm-2 col-form-label">성별</label>
										<div class="col-sm-10">
											<div class="icheck-primary d-inline">
												<input type="radio" id="memGenderM" name="memGender" value="M" <c:if test="${member.memGender eq 'M' }">checked</c:if>>
												<label for="memGenderM">남자</label>
											</div>
											<div class="icheck-primary d-inline">
												<input type="radio" id="memGenderF" name="memGender" value="F" <c:if test="${member.memGender eq 'F' }">checked</c:if>>
												<label for="memGenderF">여자</label>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label for="memEmail" class="col-sm-2 col-form-label">이메일</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="memEmail" name="memEmail" value="${member.memEmail }" placeholder="이메일을 입력해주세요.">
										</div>
									</div>
									<div class="form-group row">
										<label for="memPhone" class="col-sm-2 col-form-label">전화번호</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="memPhone" name="memPhone" value="${member.memPhone }" placeholder="전화번호를 입력해주세요.">
										</div>
									</div>
									<div class="input-group mb-3">
										<label for="inputSkills" class="col-sm-2 col-form-label">주소</label>
										<div class="col-sm-10">
											<div class="input-group mb-3">
												<input type="text" class="form-control" placeholder="우편번호를 입력해주세요" value="${member.memPostCode }" name="memPostCode">
													<span class="input-group-append">
														<button type="button" onclick="sample6_execDaumPostcode()" class="btn btn-secondary btn-flat">우편번호 찾기</button>
													</span>
											</div>
											<div class="input-group mb-3">
												<input type="text" class="form-control" placeholder="주소를 입력해주세요" name="memAddress1" value="${member.memAddress1 }">
											</div>
											<div class="input-group mb-3">
												<input type="text" class="form-control" placeholder="상세주소를 입력해주세요" name="memAddress2" value="${member.memAddress2 }">
											</div>
										</div>
									</div>
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">
											<button type="submit" class="btn btn-info">수정하기</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
$(function(){
	var imgFile = $("#imgFile");
	
	imgFile.on("change", function(event){
		var file = event.target.files[0];
		
		if(isImageFile(file)){
			var reader = new FileReader();
			reader.onload = function(e){
				$("#profileImg").attr("src", e.target.result);
			}
			reader.readAsDataURL(file);
		}else{
			alert("이미지 파일을 선택해 주세요.");
		}
	});
});

//이미지 파일인지 체크
function isImageFile(file){
	var ext = file.name.split(".").pop().toLowerCase();	// 파일명에서 확장자를 꺼낸다
	return ($.inArray(ext, ["jpg", "jpeg", "gif", "png"]) === -1 ? false : true);
}
</script>
</body>
</html>