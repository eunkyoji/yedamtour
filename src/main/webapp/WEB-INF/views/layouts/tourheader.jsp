<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-light fixed-top py-5 d-block"
		data-navbar-on-scroll="data-navbar-on-scroll">
		<div class="container">
			<a class="navbar-brand" href="index.html"><p>
					<b>YDTour</b>
				<p></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"> </span>
			</button>
			<div
				class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0"
				id="navbarSupportedContent">
				<ul
					class="navbar-nav ms-auto pt-2 pt-lg-0 font-base align-items-lg-center align-items-start">
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="#">Stays</a></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="#">Transportation</a></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="#">Tickets</a></li>
					<li class="nav-item dropdown px-3 px-lg-0"><a
						class="d-inline-block ps-0 py-2 pe-3 text-decoration-none dropdown-toggle fw-medium"
						href="#" id="navbarDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Community</a>
						<ul class="dropdown-menu dropdown-menu-end border-0 shadow-lg"
							style="border-radius: 0.3rem;" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="noticelist.do">공지사항</a></li>
							<li><a class="dropdown-item" href="qnalist.do">Q & A</a></li>
							<li><a class="dropdown-item" href="freeboradlist.do">자유게시판</a></li>
						</ul></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="loginform.do">Login</a></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="btn btn-outline-dark order-1 order-lg-0 fw-medium" href="signup.do">Sign Up</a></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="#">My Page</a></li>
					<li class="nav-item px-3 px-xl-4"><a
						class="nav-link fw-medium" aria-current="page" href="#">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>