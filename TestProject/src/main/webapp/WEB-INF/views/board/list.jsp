<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid py-4">
	<div class="row">
		<div class="col-12">
			<div class="card my-4">
				<div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
					<div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
						<h6 class="text-white text-capitalize ps-3">공지사항 게시판</h6>
					</div>
				</div>
				<div class="card-body px-0 pb-2">
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<form class="input-group input-group-outline" id="searchForm">
								<input type="hidden" name="page" id="page"/>
								<div class="col-md-2">
									<div class="input-group input-group-static mb-4">
										<select class="form-control" id="searchType" name="searchType">
											<option value="title">제목</option>
											<option value="writer">작성자</option>
										</select>
									</div>
								</div>
								<div class="col-md-8">
									<div class="ms-md-auto">
										<label class="form-label"></label> 
										<input type="text" class="form-control" name="searchWord" value="">
									</div>
								</div>
								<div class="col-md-2">
									<button type="submit" class="btn btn-outline-secondary">검색</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="card-body px-0 pb-2">
					<div class="table-responsive p-0">
						<table class="table align-items-center mb-0">
							<thead>
								<tr class="text-center">
									<th width="4%" class="text-dark font-weight-bolder">번호</th>
									<th width="px" class="text-dark font-weight-bolder">제목</th>
									<th width="14%" class="text-dark font-weight-bolder">작성자</th>
									<th width="14%" class="text-dark font-weight-bolder">작성일</th>
									<th width="6%" class="text-dark font-weight-bolder">조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr class="text-center">
									<td colspan="5" class="text-dark font-weight-bolder">조회하신 게시글이 존재하지 않습니다.</td>
								</tr>
								<tr class="text-center">
									<td><!-- 번호를 입력 --></td>
									<td class="text-dark"><!-- 제목을 입력 --></td>
									<td><!-- 작성자를 입력 --></td>
									<td>
										<span class="text-dark text-xs font-weight-bold"><!-- 작성일 입력 --></span>
									</td>
									<td>
										<span class="text-dark text-xs font-weight-bold"><!-- 조회수를 입력 --></span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer">
					<button type="button" class="btn btn-outline-primary" id="addBtn" onclick="javascript:location.href='/board/form.do'">등록</button>
				</div>
				<nav aria-label="Page navigation example" id="pagingArea">
					<!-- 페이징 입력 -->
				</nav>
			</div>
		</div>
	</div>
</div>