<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:set var="name" value='<%=(String) session.getAttribute("name")%>' />
	<header id="header" class="header fixed-top d-flex align-items-center">

		<div class="d-flex align-items-center justify-content-between">
			<a class="navbar-brand" href="reserv.do"><p>
					<b>YDTour</b>
				<p></a>
			<i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		
		<!-- End Logo -->

		<!-- End Search Bar -->

		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">

				<li class="nav-item d-block d-lg-none"><a
					class="nav-link nav-icon search-bar-toggle " href="#"> <i
						class="bi bi-search"></i>
				</a></li>
				<!-- End Search Icon -->

				
				<!-- End Notification Nav -->

				
				<!-- End Messages Nav -->
				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="tour.do">  <span
						class="d-none d-md-block ps-2">홈페이지가기</span>
				</a>
				</li>
				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="#">  <span
						class="d-none d-md-block ps-2">${name }</span>
				</a>
				</li>
				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="logout.do">  <span
						class="d-none d-md-block ps-2">Logout</span>
				</a>
				</li>
				
				<!-- End Profile Nav -->

			</ul>
		</nav>
		
		<!-- End Icons Navigation -->

	</header>
</body>
</html>