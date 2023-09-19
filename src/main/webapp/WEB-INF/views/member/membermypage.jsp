<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Pages / Login - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="niceadmin/assets/img/favicon.png" rel="icon">
<link href="niceadmin/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="niceadmin/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="niceadmin/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="niceadmin/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Aug 30 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<main>
		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="niceadmin/assets/img/logo.png" alt=""> <span
									class="d-none d-lg-block">마이페이지</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">나의 정보</h5>
									</div>

									<form class="row g-3 needs-validation" novalidate>

										<div class="col-12">
											<label for="yourId" class="form-label">아이디</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="email" name="userid" class="form-control"
													id="yourId" required placeholder="yedamtour@naver.com">
												<button style="font-size: 10px; height: 19px">수정</button>

												<button style="font-size: 10px; height: 19px;display: none">확인</button>

												<div class="invalid-feedback">아이디를 입력해 주세요.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourUsername" class="form-label">이름</label>
											<div class="input-group has-validation">
												<input type="email" name="username" class="form-control"
													id="yourUsername" required placeholder="이름">
												<button style="font-size: 10px; height: 19px;">수정</button>

												<button style="font-size: 10px; height: 19px; display: none">확인</button>

												<div class="invalid-feedback">성함을 입력해 주세요.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourNickname" class="form-label">닉네임</label>
											<div class="input-group has-validation">
												<input type="text" name="usernickname" class="form-control"
													id="yourNickname" required placeholder="닉네임">
												<button style="font-size: 10px; height: 19px">수정</button>

												<button style="font-size: 10px; height: 19px; display: none">확인</button>

												<div class="invalid-feedback">닉네임을 입력해 주세요.</div>
											</div>
										</div>


										<div class="col-12">
											<label for="yourTel" class="form-label">전화번호</label>
											<div class="input-group has-validation">
												<input type="tel" name="usertel" class="form-control"
													id="yourTel" required placeholder="01011111111">
												<button style="font-size: 10px; height: 19px">수정</button>

												<button style="font-size: 10px; height: 19px;display: none">확인</button>

												<div class="invalid-feedback">전화번호를 입력해 주세요.</div>
											</div>
										</div>



										<div class="col-12">
											<label for="yourEmail" class="form-label">이메일</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="email" name="useremail" class="form-control"
													id="yourEmail" required placeholder="이메일">
												<button style="font-size: 10px; height: 19px">수정</button>

												<button style="font-size: 10px; height: 19px;display: none">확인</button>

												<div class="invalid-feedback">이메일을 입력해 주세요.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">비밀번호</label>
											<div class="input-group has-validation">
												<input type="password" name="password" class="form-control"
													id="yourPassword" required placeholder="비밀번호">
												<button style="font-size: 10px; height: 19px">수정</button>

												<button style="font-size: 10px; height: 19px;display: none">확인</button>

												<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
											</div>
										</div>

										<div class="col-12" style="display: none">
											<label for="yourPasswordCheck" class="form-label">비밀번호
												재확인</label> <input type="password" name="password-check"
												class="form-control" id="yourPasswordCheck" required
												placeholder="비밀번호 다시 입력">
											<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
										</div>







										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">가입</button>
										</div>
										<a href="tour.do">home</a>
									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
								Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>

						</div>
						<!-- 컨테이너 끝나는 부분-->
					</div>
				</div>

			</section>

		</div>
	</main>
	<!-- End #main -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="niceadmin/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="niceadmin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="niceadmin/assets/vendor/chart.js/chart.umd.js"></script>
	<script src="niceadmin/assets/vendor/echarts/echarts.min.js"></script>
	<script src="niceadmin/assets/vendor/quill/quill.min.js"></script>
	<script
		src="niceadmin/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="niceadmin/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="niceadmin/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="niceadmin/assets/js/main.js"></script>

</body>
</html>