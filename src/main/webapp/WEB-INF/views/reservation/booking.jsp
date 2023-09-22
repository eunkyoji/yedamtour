<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Css Styles -->
<link rel="stylesheet" href="jadoo/public/assets/css/stay/booking.css"
	type="text/css">
</head>
<body>
	<section class="pt-5 pt-md-9" id="booking">
		<div class="untree_co-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6 mb-5 mb-md-0"><br><br>
						<h2 class="h3 mb-3 text-black">예약 정보</h2>
						<div class="p-3 p-lg-5 border bg-white">

							<div class="form-group row">
								<div class="col-md-6">
									<label for="c_fname" class="text-black rowtitle"> 예약자 이름<span
										class="text-danger"> *</span></label> <input type="text"
										class="form-control" id="c_fname" name="c_fname">
								</div>

								<div class="form-group row mb-5">
									<div class="col-md-6">
										<label for="c_email_address" class="text-black rowtitle"> 이메일 주소<span
											class="text-danger"> *</span>
										</label> <input type="text" class="form-control" id="c_email_address"
											name="c_email_address">
									</div>
									<div class="col-md-6">
										<label for="c_phone" class="text-black rowtitle"> 휴대폰 번호<span
											class="text-danger"> *</span></label> <input type="text"
											class="form-control" id="c_phone" name="c_phone">
									</div>
									<div class="form-group">
										<label for="c_country" class="text-black rowtitle"> 인원 수 <span
											class="text-danger"> *</span></label> <select id="c_country"
											class="form-control">
											<option value="1">인원수를 선택하세요.</option>
											<option value="2">1명</option>
											<option value="3">2명</option>
											<option value="4">3명</option>
											<option value="5">4명</option>
											<option value="6">5명</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">

						<div class="row mb-5">
							<div class="col-md-12"><br><br>
								<h2 class="h3 mb-3 text-black">입력 정보 확인</h2>
								<div class="p-3 p-lg-5 border">
									<table class="table site-block-order-table mb-5">
										<thead>
											<th>예약 숙소</th>
											<th>합계</th>
										</thead>
										<tbody>
											<tr>
												<td>Top Up T-Shirt <strong class="mx-2">x</strong> 1
												</td>
												<td>$250.00</td>
											</tr>
											<tr>
												<td>Polo Shirt <strong class="mx-2">x</strong> 1
												</td>
												<td>$100.00</td>
											</tr>
											<tr>
												<td class="text-black font-weight-bold"><strong>합계</strong></td>
												<td class="text-black font-weight-bold"><strong>$350.00</strong></td>
											</tr>
										</tbody>
									</table>

									<div class="border p-3 mb-3">
										<h3 class="h6 mb-0">
											<a class="d-block" data-bs-toggle="collapse"
												href="#collapsebank" role="button" aria-expanded="false"
												aria-controls="collapsebank">무통장 입금</a>
										</h3>
									</div>

									<div class="border p-3 mb-3">
										<h3 class="h6 mb-0">
											<a class="d-block" data-bs-toggle="collapse"
												href="#collapsecheque" role="button" aria-expanded="false"
												aria-controls="collapsecheque">카드 결제</a>
										</h3>
									</div>

									<div class="border p-3 mb-5">
										<h3 class="h6 mb-0">
											<a class="d-block" data-bs-toggle="collapse"
												href="#collapsepaypal" role="button" aria-expanded="false"
												aria-controls="collapsepaypal">카카오 페이</a>
										</h3>
									</div>

									<div class="row">
									<div class="col-md-12"><a href="thankyou.do" style="color:white">
										<button class="btn-lg">결제하기</a></button>
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

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>