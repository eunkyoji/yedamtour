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
			<div data-wow-delay="0.1s"
				style="max-width: 600px; padding-top: 100px"></div>
			<div class="row g-4">
				<div align="center">
					<img class="detailImg"
						src="ticket/img/waterpark/${vo.waterparkImg }" alt="대표사진">

					<h2 class="detailtitle">${vo.waterparkName}</h2>
				</div>

			</div>
		</div>
	</div>
	<!-- 카테고리끝 -->
		<div class="container">
			<div class="text-center mx-auto mb-5 wow fadeInUp"
				data-wow-delay="0.1s" style="max-width: 600px;">
				<h6 class="section-title bg-white text-center text-primary px-3">상세정보</h6>
			</div>
			<div class="row g-4">
				<div class=" wow fadeInUp" data-wow-delay="0.1s">
					<div class="service-item2 d-block rounded text-center alllist p-4"
						href="">

						<h4 class="mb-0"></h4>
						<div>
							<p class="hidden">
							${vo.waterparkDetail}
							</p>

							<input class="more" type="checkbox">
						</div>
					
						
						<div class="row g-4">
							<div class=" wow fadeInUp" data-wow-delay="0.1s">
								<div
									class=" cart service-item2 d-block rounded text-center alllist p-4">
									<h4 class="mb-0">장바구니</h4>
									<div align="center">
										<span>상품명: ${vo.waterparkName }</span>
										<div>
											<span id="price">가격: ${vo.waterparkPrice }원 </span> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;수량:
											</span><input id="ticketCnt" type="text" maxlength='2'
												oninput="count(event)" name="ticketCnt"
												style="width: 50px; text-align: center">
										</div>
										<div id="totalPrice" style="font-size: 14px">총 가격:</div>

										<a id="cartSubmit" style="display: none">장바구니담기</a> <input
											type="hidden" name="productId" value="${vo.waterparkId }">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
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
			function count(e) {

				e.target.value = e.target.value.replace(/[^0-9.]/g, '');

				let totalPrice = e.target.value
						* document.getElementById("price").innerHTML.replace(
								/[^0-9.]/g, '');
				document.getElementById("totalPrice").innerHTML = "총가격 : "
						+ totalPrice;

				if (e.target.value != '') {
					document
							.querySelector("#cartSubmit")
							.setAttribute("style",
									"display: block;background-color: white; width: 100px;cursor:pointer;color:black;");
				} else {
					document.querySelector("#cartSubmit").setAttribute("style",
							"display: none;");
				}
			}
			
			 $('#cartSubmit').on('click', function() {
					$.ajax({
						url : 'reservationlisttest.do',
						method : 'post',
						data : {
							wname : '${vo.waterparkName}',
							tid : ${vo.waterparkId},
							cnt: $('#ticketCnt').val()
						},
						success : function(e) {
							alert("상품을 장바구니에 담았습니다.");
							location.href = 'waterparkdetail.do?id='+${vo.waterparkId}
						},
						error : function(e) {
							alert("상품을 장바구니에 담는데 실패하였습니다.");
							location.href = 'waterparkdetail.do?id='+${vo.waterparkId}
						}
					})
				})
		</script>
</body>
</html>