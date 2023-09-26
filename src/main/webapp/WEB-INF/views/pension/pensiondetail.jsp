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
<style>
#room {
	padding: 100px;
}
</style>
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
						<h2>${pensions.pensionName }</h2>
						<span>${pensions.pensionAddress }</span>
						<div class="contact_section_text">
							<br>
							<br>
							<p>${pensions.pensionDetail }</p>
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
									</div> <br>
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
										<br> <img
											src="jadoo/public/assets/img/icons/bathicon.png" alt="">
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
						<img src="img/rooms/${pensions.pensionImg }" alt="">
					</div>
					<!-- Contact Image Close-->

					<div class="container" id="room">
						<h4>객실 안내/예약</h4>
						<br>
						<div class="row" style="display: none;">
							<div class="col-lg-4 col-md-6" id="itemdiv">
								<div class="room-item">
									<img id="roomimg" src="img/rooms/" alt="">
									<div class="ri-text">
										<h4></h4>
										<h3>만원~</h3>
										<a href="booking.do" class="primary-btn">예약하러 가기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Rooms Section Begin -->
	<section class="rooms-section spad">
		<div class="container">
			<h4></h4>
			<div class="row" style="display: none;">
				<div class="col-lg-4 col-md-6" id="itemdiv">
					<div class="room-item">
						<img id="roomimg" src="img/rooms/" alt="">
						<div class="ri-text">
							<h4></h4>
							<h3>만원~</h3>
							<a href="booking.do" class="primary-btn">예약하러 가기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Rooms Section End -->

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
//	$(document).ready(function () {
		$.ajax({
			url:"pensionsublist.do?pensionId=" + ${pensions.pensionId},
			type:"post",
			datatype:"html",
			success:function(data){
				for(let i=0; i<data.length; i++){
					let clone = $('.col-lg-4:eq(0)').clone();
					//let salePrice = result[i].itemPrice * (result[i].itemSaleRate * 0.01);
					
					//clone.css('display', 'block');
					clone.find('#roomimg').attr('src','img/rooms/' + data[i].pensionRoomImg);
					clone.find('h4').text(data[i].pensionRoomName);
					clone.find('h3').text(data[i].pensionRoomPrice + '만원~ ').append(`<span>/1박</span>`);
					$('.row').append(clone);
				}
				
				console.log(clone);
			}	
		});
//	});
	
	console.log(pensionSubId);
</script>

</body>
</html>