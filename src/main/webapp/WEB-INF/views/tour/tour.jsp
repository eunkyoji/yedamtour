<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
</head>
<body>
<section style="padding-top: 7rem;">
	<div class="bg-holder"
		style="background-image: url(jadoo/public/assets/img/메인배너.jpg);"></div>
	<!--/.bg-holder-->

	<div class="container">
		<div class="row align-items-center">
			<div class="col-md-7 col-lg-6 text-md-start text-center py-6">
				<h4 class="fw-bold text-danger mb-3">전국 호텔, 펜션, 캠핑부터 교통, 항공권 까지!</h4>
				<h1 class="hero-title">여가의 모든 순간을 책임질 수 있도록.</h1>
				<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
				<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
				<p class="mb-4 fw-medium"></p>
				<div class="modal fade" id="popupVideo" tabindex="-1"
					aria-labelledby="popupVideo" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered modal-lg">
						<div class="modal-content">
							<iframe class="rounded" style="width: 100%; max-height: 500px;"
								height="500px" src="https://www.youtube.com/embed/_lhdhL4UDIo"
								title="YouTube video player"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen="allowfullscreen"></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>

<!-- <section> begin ============================-->
<section class="pt-5 pt-md-9" id="booking">

	<div class="container">
		<div class="position-absolute z-index--1 end-0 d-none d-lg-block">
			<img src="jadoo/public/assets/img/category/shape.svg" style="max-width: 200px"
				alt="booking" />
		</div>
		<div class="mb-7 text-center">
			<h5 class="text-secondary">어떤 종류의 여행이든 몇 번의 클릭만으로!</h5>
			<h3
				class="fs-xl-10 fs-lg-8 fs-7 fw-bold font-cursive text-capitalize">지금 바로 예약하기</h3>
		</div>
		<div class="row">
			<div class="col-lg-3 col-sm-6 mb-6">
				<div
					class="card service-card shadow-hover rounded-3 text-center align-items-center">
					<div class="card-body p-xxl-5 p-4">
						<img src="jadoo/public/assets/img/category/icon1.jpg" width="75" alt="Service" />
						<h4 class="mb-3"><a href="hotellist.do">숙소</a></h4>
						<p class="mb-0 fw-medium">호텔, 리조트, 펜션, 풀빌라<br>모두</p>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 mb-6">
				<div class="card service-card shadow-hover rounded-3 text-center align-items-center">
					<a href="transportation.do"><div class="card-body p-xxl-5 p-4">
						<img src="jadoo/public/assets/img/category/icon2.png" width="75" alt="Service" />
						<h4 class="mb-3"><a href="transportation.do">교통/항공</a></h4>
						<p class="mb-0 fw-medium">버스, 기차, 항공권을 한번에</p>
					</div></a>
				</div>
			</div>
			<div class="col-lg-3 col-sm-6 mb-6">
				<div
					class="card service-card shadow-hover rounded-3 text-center align-items-center">
					<div class="card-body p-xxl-5 p-4">
						<img src="jadoo/public/assets/img/category/icon3.png" width="75" alt="Service" />
						<h4 class="mb-3"><a href="mainticket.do">티켓</a></h4>
						<p class="mb-0 fw-medium">인기 입장권 및 공연</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end of .container-->

</section>
<!-- <section> close ============================-->

<!-- <section> begin ============================-->
<section class="pt-5" id="destination">

	<div class="container">
		<div
			class="position-absolute start-100 bottom-0 translate-middle-x d-none d-xl-block ms-xl-n4">
		</div>
		<div class="mb-7 text-center">
			<h5 class="text-secondary">어디로 가시나요?</h5>
			<h3
				class="fs-xl-10 fs-lg-8 fs-7 fw-bold font-cursive text-capitalize">인기 숙소별 특가</h3>
		</div>
		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card overflow-hidden shadow">
					<img class="card-img-top" src="img/rooms/mainhotel.jpg" alt="" />
					<div class="card-body py-4 px-3">
						<div
							class="d-flex flex-column flex-lg-row justify-content-between mb-3">
							<h4 class="text-secondary fw-medium">
								<a class="link-900 text-decoration-none stretched-link"
									href="hoteldetail.do?hotelId=6"><b>${hotels.hotelName }</b></a>
							</h4>
							<span class="fs-1 fw-medium"><fmt:formatNumber value="${hotels.hotelPrice }" pattern="#,###" />원~</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card overflow-hidden shadow">
					<img class="card-img-top" src="img/rooms/mainpension.jpg" alt="" />
					<div class="card-body py-4 px-3">
						<div
							class="d-flex flex-column flex-lg-row justify-content-between mb-3">
							<h4 class="text-secondary fw-medium">
								<a class="link-900 text-decoration-none stretched-link"
									href="pensiondetail.do?pensionId=3"><b>${pensions.pensionName }</b></a>
							</h4>
							<span class="fs-1 fw-medium"><fmt:formatNumber value="${pensions.pensionPrice }" pattern="#,###" />원~</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card overflow-hidden shadow">
					<img class="card-img-top" src="img/rooms/maincamping.jpg" alt="" />
					<div class="card-body py-4 px-3">
						<div
							class="d-flex flex-column flex-lg-row justify-content-between mb-3">
							<h4 class="text-secondary fw-medium">
								<a class="link-900 text-decoration-none stretched-link"
									href="campingdetail.do?campingId=2"><b>${campings.campingName }</b></a>
							</h4>
							<span class="fs-1 fw-medium"><fmt:formatNumber value="${campings.campingPrice }" pattern="#,###" />원~</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end of .container-->
</section>
</body>
</html>