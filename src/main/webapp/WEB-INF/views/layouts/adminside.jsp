<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<aside id="sidebar" class="sidebar">

		<ul class="sidebar-nav" id="sidebar-nav">

			<!-- 예약정보 리스트 Start -->
			<li class="nav-item">
				<a class="nav-link collapsed" href="reservationlist.do">
					<i></i> <span>예약정보 리스트</span>
				</a>
			</li>
			<!-- 예약정보 리스트 E n d -->
			<!-- 회원정보 리스트 Start -->
			<li class="nav-item">
				<a class="nav-link collapsed" href="memberlist.do">
					<i></i> <span>회원목록</span>
				</a>
			</li>
			<!-- 회원정보 리스트 E n d -->
			<!-- 게시판 관리 Start -->
			<li class="nav-item"><a class="nav-link collapsed" data-bs-target="#board-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-layout-text"></i>
					<span>게시판 관리</span>
					<i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="board-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="noticelist.do"> <i class="bi bi-circle"></i><span>공지사항</span></a></li>
					<li><a href="qnalist.do"><i class="bi bi-circle"></i><span>Q & A</span></a></li>
					<li><a href="freeboardlist.do"><i class="bi bi-circle"></i><span>자유게시판</span></a></li>
				</ul>
			</li>
			<!-- 게시판 관리 E n d -->
		</ul>
	</aside>
</body>
</html>