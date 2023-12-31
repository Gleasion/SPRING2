<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a></li>
	</ul>
</nav>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<a href="" class="brand-link">
		<img src="${pageContext.request.contextPath }/resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">SPRING</span>
	</a>

	<div class="sidebar">
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<c:if test="${not empty member }">
				<c:set target="${sessionScope.SessionInfo }" property="memProfileImg" value="${member.memProfileImg }"/>
				<c:set target="${sessionScope.SessionInfo }" property="memName" value="${member.memName }"/>
			</c:if>
			<div class="image">
				<img src="${sessionScope.SessionInfo.memProfileImg}" class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="/notice/profile.do" class="d-block">${sessionScope.SessionInfo.memName }</a>
			</div>
		</div>
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
				<li class="nav-item">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>공지사항</p>
					</a>
				</li>
			</ul>
		</nav>
	</div>
</aside>