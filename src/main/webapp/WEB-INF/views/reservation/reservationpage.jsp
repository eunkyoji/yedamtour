<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="jadoo/public/assets/css/stay/bookingpage.css" type="text/css">
</head>
<body>

	<section class="pt-5 pt-md-9" id="booking">
		<div class="contact_section">
			<div class="container">
				<br>
				<h4>예약자 정보</h4>
			</div>
		</div>
	</section>

		<div class="untree_co-section before-footer-section">
			<div class="container">
				<div class="row mb-5">
					<form class="col-md-12" method="post">
						<div class="site-blocks-table">
							<table class="table">
								<thead>
									<tr>
										<th class="product-name">예약 정보</th>
										<th class="product-room">객실</th>
										<th class="product-price">가격</th>
										<th class="product-remove">삭제</th>
									</tr>
								</thead>
								<tbody>
									<tr>										
										<td class="product-name">
											<h2 class="h5 text-black">${hotels.hotelName }</h2>
										</td>
										<td></td>
										<td>${hotels.hotelPrice }만원</td>
										<td><a href="#" class="btn btn-black btn-sm">X</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>

				<div class="row">
					<div class="col-md-6 pl-5">
						<div class="row justify-content-end">
							<div class="col-md-7">
								<div class="row">
									<div class="col-md-12 text-right border-bottom mb-5">
										<h3 class="text-black h4 text-uppercase">총 상품</h3>
									</div>
								</div>
								<div class="row mb-5">
									<div class="col-md-6">
										<span class="text-black">합계</span>
									</div>
									<div class="col-md-6 text-right">
										<strong class="text-black">$230.00</strong>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12"><a href="payment.do" style="color:white">
										<button class="btn btn-black btn-lg py-3 btn-block">결제하기</a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>