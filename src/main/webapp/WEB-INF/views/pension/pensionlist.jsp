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
	<form id="search" action="">
		<section class="pt-5 pt-md-9" id="booking">
			<div class="row">
				<div class="col-lg-3 col-sm-6 mb-6">
					<div
						class="card service-card shadow-hover rounded-3 text-center align-items-center">
						<div class="card-body p-xxl-5 p-4">
							<img src="jadoo/public/assets/img/stay/호텔icon.png" width="63"
								alt="Service" />
							<h4 class="mb-3">
								<a href="hotellist.do">호텔/리조트</a>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 mb-6">
					<div
						class="card service-card shadow-hover rounded-3 text-center align-items-center">
						<div class="card-body p-xxl-5 p-4">
							<img src="jadoo/public/assets/img/stay/펜션icon.png" width="70"
								alt="Service" />
							<h4 class="mb-3">
								<a href="pensionlist.do">펜션/풀빌라</a>
							</h4>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-sm-6 mb-6">
					<div
						class="card service-card shadow-hover rounded-3 text-center align-items-center">
						<div class="card-body p-xxl-5 p-4">
							<img src="jadoo/public/assets/img/stay/캠핑icon.png" width="75"
								alt="Service" />
							<h4 class="mb-3">
								<a href="campinglist.do">캠핑</a>
							</h4>
						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Rooms Section Begin -->
		<section class="rooms-section spad">
			<div class="container">
				<h4>인기 추천 TOP</h4>
				<br>
				<div class="row">
					<c:forEach items="${pensions }" var="p">
						<div class="col-lg-4 col-md-6">
							<div class="room-item">
								<img src="img/rooms/${p.pensionImg }" alt="">
								<div class="ri-text">
									<h4>${p.pensionName }</h4>
									<h3>
										${p.pensionPrice }만원~<span>/1박</span>
									</h3>
									<table>
										<tbody>
											<tr>
												<td class="r-o">최대 인원:</td>
												<td>${p.pensionCount }인</td>
											</tr>
											<tr>
												<td class="r-o">서비스:</td>
												<td>${p.pensionService }</td>
											</tr>
										</tbody>
									</table>
							<a class="primary-btn" onclick="pensionSelect(${p.pensionId })">자세히 보기</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</form>
	<form id="sform" action="pensiondetail.do" method="post">
		<input type="hidden" id="pensionId" name="pensionId">
	</form>
	<!-- Rooms Section End -->
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

	<script>
function pensionSelect(id){
			console.log(id);
			let form = document.getElementById("sform");
			form.pensionId.value = id;
			form.submit();
		}
</script>
</body>
</html>