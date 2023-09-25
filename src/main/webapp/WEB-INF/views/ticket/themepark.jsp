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
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
					<a class="service-item d-block rounded text-center h-1001 p-4"
						href="themepark.do"> <img class="maincategoryImg"
						src="ticket/img/놀이공원.png" alt="놀이공원">
						<h4 class="mb-0">테마파크</h4>
					</a>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s"
					style="height: 20%">
					<a class="service-item d-block rounded text-center h-100 p-4"
						href="aquarium.do"> <img class="categoryImg"
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
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<h6 class="section-title bg-white text-center text-primary px-3">Services</h6>
				<h1 class="display-6 mb-4">테마파크 리스트</h1>
			</div>
			<div class="iii row g-4">
				<c:forEach items="${vo}" var="t" varStatus="s">

				
						<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
							<a class="service-item d-block rounded text-center alllist p-4"
								href="themeparkdetail.do?id=${t.themeparkId }"> <img
								class="img-fluid rounded mb-4"
								src="ticket/img/themepark/${t.themeparkImg }"
								style="width: 370px; height: 210px" alt="">
								<h4 class="mb-0">${t.themeparkName }</h4> <span>${t.themeparkPrice }원</span><br>
								<span>${t.themeparkBrif }</span>

							</a>
						</div>
						
				</c:forEach>
			</div>
			<div align="center">
				<button>리스트 더보기</button>
			</div>

		</div>

	<script>
		/* $('.themeparklist').on('click', function() {
			console.log("ddddddddddddddd")
			$.ajax({
				url : 'detailticket.do',
				method : 'post',
				data : {
					id : $('.ticketId').val()

				},
				success : function(e) {
					console.log('성공');
				},
				error : function(e) {
					console.log(e);
				}
			})
		}) */
	</script>



	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="ticket/lib/wow/wow.min.js"></script>
	<script src="ticket/lib/easing/easing.min.js"></script>
	<script src="ticket/lib/waypoints/waypoints.min.js"></script>
	<script src="ticket/lib/counterup/counterup.min.js"></script>
	<script src="ticket/lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="ticket/lib/lightbox/js/lightbox.min.js"></script>


</body>
</html>