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
									class="logo d-flex align-items-center w-auto">  <span
									class="d-none d-lg-block">회 원 가 입</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">개인정보 입력</h5>
										<p class="text-center small">아래 빈칸에 정보를 기입해주세요.</p>
									</div>

									<form class="row g-3 needs-validation" action="signup.do"
										method="post">

										<div class="col-12">
											<label for="memberName" class="form-label">이름</label>
											<div class="input-group has-validation">
												<input type="text" name="memberName" class="form-control"
													id="memberName" required placeholder="이름 입력">
												<div class="invalid-feedback">성함을 입력해 주세요.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="memberId" class="form-label">아이디</label><label
												for="memberId">&nbsp;아이디는 이메일형식입니다.</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="email" name="memberId" class="form-control"
													id="memberId" required
													placeholder="ex: yedamtour@naver.com">
												<div class="invalid-feedback">아이디를 입력해 주세요.</div>
												<button style="font-size: 10px; height: 19px" type="button"
													id="idCheck" value="No" onclick="memberIdCheck()">중복체크</button>
											</div>
										</div>

										<div class="col-12">
											<label for="memberPassword" class="form-label">비밀번호</label> <input
												type="password" name="memberPassword" class="form-control"
												id="memberPassword" required placeholder="비밀번호 입력">
											<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
										</div>

										<div class="col-12">
											<label for="memberPasswordCheck" class="form-label">비밀번호
												재확인</label> <input type="password" name="memberPasswordCheck"
												class="form-control" id="memberPasswordCheck" required
												placeholder="비밀번호 다시 입력">
											<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
										</div>


										<div class="col-12">
											<label for="memberPhone" class="form-label">전화번호</label>
											<div class="input-group has-validation">
												<input type="tel" name="memberPhone" class="form-control"
													id="memberPhone" required placeholder="숫자만 입력">
												<div class="invalid-feedback">전화번호를 입력해 주세요.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="memberNickname" class="form-label">닉네임</label>
											<div class="input-group has-validation">
												<input type="text" name="memberNickname"
													class="form-control" id="memberNickname" required
													placeholder="닉네임 입력">
												<div class="invalid-feedback">닉네임을 입력해 주세요.</div>
											</div>
										</div>


										<div class="col-12">
											<button id="sign" onclick="plzcheck()" class="btn btn-primary w-100" type="button">가입</button>
										</div>
										<a href="tour.do">홈가기</a>

									</form>

								</div>
							</div>

							<div class="credits">
								<!-- All the links in the footer should remain intact. -->
								<!-- You can delete the links only if you purchased the pro version. -->
								<!-- Licensing information: https://bootstrapmade.com/license/ -->
								<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
								Copyright 2023© By YEDAMTOUR.
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
	
	<script>
	function memberIdCheck() {  //aJax 사용
		console.log('aaa');
		let url = "check.do"
		let payload = document.getElementById("memberId").value;
		console.log(payload);
		url = url + "?memberId=" + payload;
		
		fetch(url)  //get 방식
			.then(response => response.text())
			.then(text => membercheck(text));
	}
	
	function membercheck(str) {
		var email = document.getElementById("memberId").value
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

			if(exptext.test(email)==false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
			alert("이메일형식이 올바르지 않습니다.");
			}else if(str == 'Yes' ) {
				
			alert("사용가능한 아이디 입니다.");
			document.getElementById("idCheck").value = "Yes";
			}else{
			alert("이미 사용하는 아이디 입니다.");
			document.getElementById("memberId").focus();
		}
	}
	
	function plzcheck() {
			let a= document.getElementById("idCheck").value;
			//document.getElementById("memberId").value;
			
			if(a != 'Yes' ) {
				alert("아이디 중복체크를 해주세요");
				document.getElementById("memberId").focus();
				return;
			}
			document.getElementById("sign").setAttribute("type","submit");
	}
	
	
	</script>

</body>
</html>