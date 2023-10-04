<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>DGcom - Web Design Agency HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="ticket/lib/animate/animate.min.css" rel="stylesheet">
<link href="ticket/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="ticket/lib/lightbox/css/lightbox.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="ticket/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="ticket/css/styleticket.css" rel="stylesheet">
</head>
<body>

	<!-- 카테고리 시작 -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px; padding-top: 100px">
				<h6 class="section-title bg-white text-center text-primary px-3">카테고리</h6>
			</div>
			<div class="row g-4">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
					style="height: 20%">
					<a class="service-item d-block rounded text-center h-100 p-4"
						href="themepark.do"> <img class="categoryImg"
						src="ticket/img/놀이공원.png" alt="놀이공원">
						<h4 class="mb-0">테마파크</h4>
					</a>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
					<a class="service-item d-block rounded text-center h-1001 p-4"
						href="aquarium.do"> <img class="maincategoryImg"
						src="ticket/img/아쿠아리움.png" alt="아쿠아리움">
						<h4 class="mb-0">아쿠아리움</h4>
					</a>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s"
					style="height: 20%">
					<a class="service-item d-block rounded text-center h-100 p-4"
						href="waterpark.do"> <img class="categoryImg"
						src="ticket/img/워터파크.png" alt="">
						<h4 class="mb-0">워터파크</h4>
					</a>
				</div>

			</div>
		</div>
	</div>
	<!-- 카테고리끝 -->
	<div class="container-xxl py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<h6 class="section-title bg-white text-center text-primary px-3">Services</h6>
				<h1 class="display-6 mb-4">아쿠아리움 리스트</h1>
				
			</div>

			<div class="iii row g-4">
				<c:forEach items="${vo}" var="a">
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
						<a class="service-item d-block rounded text-center alllist p-4"
							href="aquariumdetail.do?id=${a.aquariumId }"> <img
							class="img-fluid rounded mb-4"
							src="ticket/img/aquarium/${a.aquariumImg }"
							style="width: 370px; height: 210px" alt="">
							<h4 class="mb-0">${a.aquariumName }</h4> <span>${a.aquariumPrice }원</span><br>
							<span>${a.aquariumBrif }</span>

						</a>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- 씨:if 	3번째7번째 11번째는 두줄정렬되게 status.index-->
		

	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="ticket/lib/wow/wow.min.js"></script>
	<script src="ticket/lib/easing/easing.min.js"></script>
	<script src="ticket/lib/waypoints/waypoints.min.js"></script>
	<script src="ticket/lib/counterup/counterup.min.js"></script>
	<script src="ticket/lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="ticket/lib/lightbox/js/lightbox.min.js"></script>
	<script>
		/* $('.aqualist').on('click', function() {
			console.log("ddddddddddddddd")
			$.ajax({
				url : 'detailticket.do?id=' {a.aquariumId},
				method : 'post',
				data : {
					id : $('.ticketId').val()
					
				},
				success : function(e) {
					console.log('성공');
					location
				},
				error : function(e) {
					console.log(e);
				}
			})
		}) */
	</script>
</body>
</html>