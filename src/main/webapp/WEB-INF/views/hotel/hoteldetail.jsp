<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
	<!-- Contact -->
	<section class="pt-5 pt-md-9" id="booking">
		<br> <br>
		<div class="contact_section">
			<div class="container">
				<div class="row">
					<!-- Contact Content -->
					<div class="col-lg-5">
						<h2>${hotels.hotelName }</h2>
						<span>${hotels.hotelAddress }</span>
						<div class="contact_section_text">
							<br><br>
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
									<div id="imgdiv">
										<img id="bath" src="jadoo/public/assets/img/icons/bathicon.png" alt="">
										<img id="parking" src="jadoo/public/assets/img/icons/parkicon.png" alt="">
										<img id="nosmoke" src="jadoo/public/assets/img/icons/nosmoke.png" alt="">
										<img id="wifi" src="jadoo/public/assets/img/icons/wifiicon.png" alt="">
									</div>
								</li>
							</ul>
						</div>
					</div>
					
					<!-- Contact Image -->
					<div class="col-lg-5 contact_section_col">
						<img id="hotelimg" src="img/rooms/${hotels.hotelImg }" alt="">
					</div>
					<!-- Contact Image Close-->

					<div class="container" id="room">
						<h4>객실 안내/예약</h4>
						<br>
						<div class="row" style="display: none;">
							<div class="col-lg-4 col-md-6" id="itemdiv">
								<form id="frm" action="booking.do" method="post" enctype="form-data">
									<div class="room-item">
										<img id="roomimg" src="img/rooms/" alt="">
										<div class="ri-text">
											<h4></h4>
											<h3></h3>
											<a class="primary-btn">예약하러 가기</a>
										</div>
									</div>
									<p id="subId"></p>
									<input type="hidden" id="hotelId" name="hotelId" value="${hotels.hotelId }">
									<input type="hidden" id="hotelSubId" name="hotelSubId">
									<input type="hidden" id="memberId" name="memberId" value="${id }">
									<input type="hidden" id="categoryId" name="categoryId" value="1">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
//	$(document).ready(function () {
	$.ajax({
        url:"hotelsublist.do?hotelId=" + ${hotels.hotelId},
        type:"post",
        datatype:"html",
        success:function(data){
           for(let i=0; i<data.length; i++){
              let clone = $('.col-lg-4:eq(0)').clone();
              let roomprice = data[i].hotelRoomPrice;
              clone.find('#roomimg').attr('src','img/rooms/' + data[i].hotelRoomImg);
              clone.find('h4').text(data[i].hotelRoomName);
              clone.find('h3').text(roomprice.toLocaleString() + '원~ ').append(`<span>/1박</span>`);
              clone.find('a').attr('onclick', 'booking('+data[i].hotelSubId+')');
              $('.row').append(clone);
            }
         }   
      });
//	});
		function booking(id){
			console.log(id);
			let form = document.getElementById("frm");
			form.hotelSubId.value = id;
			form.submit();
		}
</script>

</body>
</html>