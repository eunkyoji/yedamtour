<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Pages / Login - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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

								<form class="row g-3 needs-validation" id="test" method="post">
									<div class="card-body">

										<div class="pt-4 pb-2">
											<h5 class="card-title text-center pb-0 fs-4">나의 정보</h5>
										</div>



										<div class="col-12">
											<label for="memberId" class="form-label">아이디</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="inputGroupPrepend">@</span>
												<input type="email" name="memberId" class="form-control"
													id="memberId" value="${list.memberId }">
												<button class="editBtn"
													style="font-size: 10px; height: 19px; display: none"
													type="button">수정</button>

												<button style="font-size: 10px; height: 19px" type="button"
													id="idCheck" value="No" onclick="memberIdCheck()">중복체크</button>



											</div>
										</div>


										<div class="col-12">
											<label for="memberName" class="form-label">이름</label>
											<div class="input-group has-validation">
												<input type="text" name="memberName" class="form-control"
													id="memberName" value="${list.memberName }">
												<button class="editBtn"
													style="font-size: 10px; height: 19px" type="button">수정</button>

											</div>
										</div>

										<div class="col-12">
											<label for="memberNickname" class="form-label">닉네임</label>
											<div class="input-group has-validation">
												<input type="text" name="memberNickname"
													class="form-control" id="memberNickname"
													value="${list.memberNickname }">
												<button class="editBtn"
													style="font-size: 10px; height: 19px" type="button">수정</button>

												<button style="font-size: 10px; height: 19px; display: none">확인</button>


											</div>
										</div>


										<div class="col-12">
											<label for="memberPhone" class="form-label">전화번호</label>
											<div class="input-group has-validation">
												<input type="tel" name="memberPhone" class="form-control"
													id="memberPhone" value="${list.memberPhone }">
												<button class="editBtn"
													style="font-size: 10px; height: 19px" type="button">수정</button>

												<button style="font-size: 10px; height: 19px; display: none">확인</button>


											</div>
										</div>
									</div>

									<div class="col-12">
										<label for="memberPassword" class="form-label">비밀번호</label>
										<div class="input-group has-validation">
											<input type="password" name="memberPassword"
												class="form-control" id="memberPassword" required
												placeholder="비밀번호" value="${list.memberPassword }">
											<button class="editBtn" style="font-size: 10px; height: 19px"
												type="button">수정</button>

											<button style="font-size: 10px; height: 19px; display: none">확인</button>


										</div>
									</div>

									<div class="col-12 Check" style="display: none">
										<label for="passwordCheck" class="form-label">비밀번호 재확인</label>
										<input type="password" name="passwordCheck"
											class="form-control" id="passwordCheck" required
											placeholder="비밀번호 다시 입력">

									</div>
								</form>






								<div class="col-12">
									<button id="memberDelete" class="btn btn-primary w-100"
										type="button">회원탈퇴</button>
								</div>
								<a href="tour.do">home</a>


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
					<form id="selectfrm" action="memberedit.do" method="POST">
						<input type="hidden" id="useId" name="useId"
							value="${list.memberId }" readonly="readonly">
					</form>
				</div>
			</section>
		</div>


	</main>
	<!-- End #main -->
	<script>
	/* 	function edit() {
			document.querySelector("#idCheck").setAttribute("style",
					"display: block; font-size: 10px; height: 19px;");
			document.getElementById('memberId').removeAttribute("readonly");
			console.log(document.getElementById('memberId'));

			//document.querySelector(".Check").setAttribute("style","display: block;");

			console.log(document.querySelector(".Check"));

		} */
		
		//수정누르면 작동
		$('.editBtn').on('click', function(){
			
			console.log("aaaaa");
			$.ajax({
				url:'memberedit.do',
				method:'post',
				data:{id : $('#memberId').val(),
				 password : $('#memberPassword').val(),
				 name : $('#memberName').val(),
				 nickname : $('#memberNickname').val(),
				 phone : $('#memberPhone').val(),
				},
				success: function(e){
					alert("정보를 변경하는데 성공했습니다.");		
				},
				error: function(e){
					alert("정보를 변경하는데 실패했습니다.");
				}
			})
			})
		
			$('#memberDelete').on('click', function(){
			console.log("aaaaa");
			$.ajax({
				url:'memberdelete.do',
				method:'post',
				data:{id : $('#memberId').val()
				},
				success: function(e){
					alert("회원탈퇴가 처리되었습니다.");
					let url ="tour.do"
					location.replace(url);
					
				},
				error: function(e){
					console.log(e);
				}
			})
			})
			
			
			
			
		function memberIdCheck() {  //aJax 사용
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
				document.getElementById("editBtn").setAttribute("style","display: block");
				}else{
				alert("이미 사용하는 아이디 입니다.");
				document.getElementById("memberId").focus();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//add event
		/* $('#btnId').on('click', function(){
			let id = $('#memberId').val();			
			$.ajax({
				url:'check.do',
				method:'post',
				data:{'id' : id},
				success: function(e){
					console.log(e.retCode);
					if(e.retCode == "Fail"){
						alert('사용불가능한 아이디입니다.');
					}else{
						alert('사용가능한 아이디입니다.')	;
					}					
				},
				error: function(e){
					console.log(e);
				}
			})
		}) */
		
		/* function idCheck() {
			let newId = document.getElementById('memberId').value
			console.log(newId);
			if (newId != '') {
				fetch('check.do?id='+newId)
				.then(function(e){
					return e.text();
					
				}).then(x => {alert(x)
					
					if(x != "'이미 존재하는 아이디입니다.'"){
					document.getElementById('memberId').setAttribute("readonly",
					"readonly");	
					}
				})
			}
			
		}

		
		
		function memberDel(){
			fetch('memberdelete.do')
			.then(function(){
				
			})
		} */
	</script>




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