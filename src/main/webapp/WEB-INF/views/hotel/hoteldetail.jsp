<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Css Styles -->
<link rel="stylesheet" href="jadoo/public/assets/css/stay/staymain.css"
	type="text/css">
</head>
<body>

	<!-- Contact -->
	<section class="pt-5 pt-md-9" id="booking">
		<br>
		<br>
		<div class="contact_section">
			<div class="container">
				<div class="row">
					<!-- Contact Content -->
					<div class="col-lg-5">
						<h2>${hotels.hotelName }</h2>
						<span>${hotels.hotelAddress }</span>
						<div class="contact_section_text">
							<br>
							<br>
							<p>${hotels.hotelDetail }</p>
						</div>
						<div class="contact_section_info">
							<ul>
								<li
									class="d-flex flex-row align-items-center justify-content-start">
									<div>
										<div
											class="d-flex flex-column align-items-center justify-content-center">
											<img src="images/icon_1.png" alt="">
										</div>
									</div>
									<br>
								</li>
								<li
									class="d-flex flex-row align-items-center justify-content-start">
									<div>
										<div
											class="d-flex flex-column align-items-center justify-content-center">
											<img src="images/icon_2.png" alt="">
										</div>
									</div>
								</li>
								<li
									class="d-flex flex-row align-items-center justify-content-start">
									<div>
										<img src="jadoo/public/assets/img/icons/bathicon.png" alt="">
										<img src="jadoo/public/assets/img/icons/parkicon.png" alt="">
										<img src="jadoo/public/assets/img/icons/nosmoke.png" alt="">
										<img src="jadoo/public/assets/img/icons/wifiicon.png" alt="">
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!-- Contact Image -->
					<div class="col-lg-7 contact_section_col">
						<img src="img/rooms/${hotels.hotelImg }" alt="">
					</div>
					<!-- Contact Image Close-->

				</div>
			</div>
		</div>
	</section>
	<
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- Rooms Section Begin -->
	<section class="rooms-section spad">
		<div class="container">
			<h4>객실 안내/예약</h4>
			<br>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="room-item">
						<img src="img/rooms/${hotels.hotelRoomImg1 }" alt="">
						<div class="ri-text">
							<h4>${hotels.hotelRoomName1 }</h4>
							<h3>
								${hotels.hotelRoomPrice1 }만원~<span>/1박</span>
							</h3>
							<table>
							</table>
							<a href="bookingpage.do" class="primary-btn">예약하러 가기</a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="room-item">
						<img src="img/rooms/${hotels.hotelRoomImg2 }" alt="">
						<div class="ri-text">
							<h4>${hotels.hotelRoomName2 }</h4>
							<h3>
								${hotels.hotelRoomPrice2 }만원~<span>/1박</span>
							</h3>
							<table>
							</table>
							<a href="bookingpage.do" class="primary-btn">예약하러 가기</a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="room-item">
						<img src="img/rooms/${hotels.hotelRoomImg3 }" alt="">
						<div class="ri-text">
							<h4>${hotels.hotelRoomName3 }</h4>
							<h3>
								${hotels.hotelRoomPrice3 }만원~<span>/1박</span>
							</h3>
							<table>
							</table>
							<a href="bookingpage.do" class="primary-btn">예약하러 가기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Rooms Section End -->

	<script src="http://code.jquery.com/jquery-latest.js"></script>

</body>
</html>