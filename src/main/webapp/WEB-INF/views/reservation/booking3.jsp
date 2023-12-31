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
<link rel="stylesheet" href="jadoo/public/assets/css/stay/booking.css"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="jadoo/public/assets/css/stay/datepicker.css" />
</head>
<body>
	<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
	<form id="frm" action="reservationInsert.do" method="post" enctype="form-data">
		<section class="pt-5 pt-md-9" id="booking">
			<div class="untree_co-section">
				<div class="container">
					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0">
							<br> <br>
							<h2 class="h3 mb-3 text-black">예약 정보</h2>
							<div class="p-3 p-lg-5 border bg-white">
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_fname" class="text-black rowtitle"> 예약자
											이름<span class="text-danger"> *</span>
										</label> <input type="text" class="form-control" id="reservationName"
											name="reservationName" value="${member.memberName }">
									</div>

									<div class="form-group row mb-5">
										<div class="col-md-6">
											<label for="c_email_address" class="text-black rowtitle">이메일
												주소<span class="text-danger"> *</span>
											</label> <input type="text" class="form-control" id="reservationWriterId"
												name="reservationWriterId" value="${member.memberId }">
										</div>
										<div class="col-md-6">
											<label for="c_phone" class="text-black rowtitle">휴대폰
												번호<span class="text-danger"> *</span>
											</label> <input type="text" class="form-control" id="reservationPhone"
												name="reservationPhone" value="${member.memberPhone }">
										</div>
										<div class="form-group">
											<label for="c_country" class="text-black rowtitle">인원
												수 <span class="text-danger"> *</span>
											</label> <select id="reservationPersonnel" onchange="selectBoxChange(this.value);"
											name="reservationPersonnel" class="form-control">
												<option value="1">1명</option>
												<option value="2">2명</option>
												<option value="3">3명</option>
												<option value="4">4명</option>
												<option value="5">5명</option>
												<option value="6">6명</option>
											</select>
										</div>
										<div class="col-md-6 datepk">
											<label class="text-black rowtitle">예약 날짜<span
												class="text-danger"> *</span>
											</label><input type="text" name="daterange" class="form-control"
												value="" placeholder="예약 날짜를 선택하세요.">
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="row mb-5">
								<div class="col-md-12">
									<br> <br>
									<h2 class="h3 mb-3 text-black">입력 정보 확인</h2> 
									<div id="info">
										<div class="p-3 p-lg-5 border">
											<table class="table site-block-order-table mb-5">
												<thead>
													<th>예약 숙소</th>
													<th>금액</th>
												</thead>
												<tbody>
													<tr>

														<td class="title">${reserves.campingName }
															(${reserves.campingRoomName })</td>
														<td class="hab"><fmt:formatNumber
															value="${reserves.campingRoomPrice }" pattern="#,###" />원
															<input type="hidden" id="reservationPrice" name="reservationPrice" value="${reserves.campingRoomPrice }">
													</td>
													</tr>
													<tr>
														<td class="text-black font-weight-bold"><strong>TOTAL</strong></td>
														<td class="text-black font-weight-bold"><strong id="totalPrice">
															<fmt:formatNumber value="${reserves.campingRoomPrice }" pattern="#,###" />원
														</strong></td>
													</tr>
												</tbody>
											</table>
											<div class="row">
												<div class="col-md-12">
													<a href="membermypage.do">
														<input type="button" class="btn-lg" value="예약하기">
													</a>
												</div>
											</div>
											<input type="hidden" id="campingId" name="campingId"
												value="${reserves.campingId }"> <input type="hidden"
												id="campingSubId" name="campingSubId"
												value="${reserves.campingSubId }"> <input
												type="hidden" id="memberId" name="memberId" value="${id }">
											<input type="hidden" id="categoryId" name="categoryId"
												value="${reserves.categoryId }">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- </form> -->
				</div>
			</div>
		</section>
	</form>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/custom.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<!-- <script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				url : "booking.do",
				type : "post",
				datatype : "html",

				success : function(data) {
					console.log(data[0]);
					if (data[0].categoryId == "1") {
						let clone = $('.p-lg-5(1)').clone();
						clone.find('.title').text(data[0].hotelName);
						clone.find('.hab').text(data[0].hotelRoomPrice);
						$('#info').append(clone);
					} else if (data[0].categoryId == "2") {
						let clone = $('.p-lg-5(1)').clone();
						clone.find('.title').text(data[0].pensionName);
						clone.find('.hab').text(data[0].pensionRoomPrice);
						$('#info').append(clone);
					} else if (data[0].categoryId == "3") {
						let clone = $('.p-lg-5(1)').clone();
						clone.find('.title').text(data[0].campingName);
						clone.find('.hab').text(data[0].campingRoomPrice);
						$('#info').append(clone);
					}
				}
			});
		});
	</script> -->
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<script>
		$(function() {
			$('input[name="daterange"]').daterangepicker(
					{
						locale:{"format":'YYYY/MM/DD'}
					},
					function(start, end, label) {
						console.log("A new date selection was made: "
								+ start.format('YYYY-MM-DD') + ' to '
								+ end.format('YYYY-MM-DD'));
					});
		});
	</script>
	<script>
	function selectBoxChange(value){
		console.log("값변경테스트: ",$("#totalPrice"));
		console.log($("#reservationPrice").val());
		let gab = 0;
		if(value>=3){
			gab = parseInt($("#reservationPrice").val())+(value-3)*30000
		}else{
			gab = $("#reservationPrice").val()
		}		
		$("#totalPrice").text(gab.toLocaleString()+"원");
	}
	</script>
</body>
</html>