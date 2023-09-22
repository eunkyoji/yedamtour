<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<!-- <link href="jadoo/public/assetslist/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<!-- <link href="jadoo/public/assetslist/css/tiny-slider.css" rel="stylesheet">
<link href="jadoo/public/assetslist/css/style.css" rel="stylesheet"> -->
<title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co</title>
</head>

<body>

		<div class="untree_co-section before-footer-section">
			<form action="resultairplane.do" class="col-md-12" method="post">
			<div class="container" style="margin-top: 200px;">
				<div class="intro-excerpt" style="text-align: center">
					<h1>${startDate}</h1>
					<input type="hidden" name="startDate" value="${startDate }">
				</div>
				
				<div class="row mb-5">
					
						<div class="site-blocks-table">
							<table class="table">
								<thead>
									<tr>
									<th>선택</th>
										<th class="product-name">등급</th>
										<th class="product-price">출발시간</th>
										<th class="product-arrow"></th>
										<th class="product-quantity">도착시간</th>
										<th class="product-total">가격</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${airplanes }" var="a">
										<tr>
										<td><input type="radio" value="${a.airplaneId }" name="direction"></td>
											<td class="product-name">
												<h2 class="h5 text-black">${a.airplaneGrade }</h2>
											</td>
											<td>${a.airplaneDeptime }</td>
											<td>-></td>
											<td>${a.airplaneArrtime }</td>
											<td>${a.airplanePrice }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
				</div>
			</div>
			<div class="container" style="margin-top: 200px;">
				<div class="intro-excerpt" style="text-align: center">
					<h1>${finishDate}</h1>
					<input type="hidden" name="finishDate" value="${finishDate }">
				</div>
				<div class="row mb-5">
					
						<div class="site-blocks-table">
							<table class="table">
								<thead>
									<tr>
									<th>선택</th>
										<th class="product-name">등급</th>
										<th class="product-price">출발시간</th>
										<th class="product-arrow"></th>
										<th class="product-quantity">도착시간</th>
										<th class="product-total">가격</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${airplanes }" var="a">
										<tr>
											<td><input type="radio" value="${a.airplaneId }" name="direction1"></td>
											<td class="product-name">
												<h2 class="h5 text-black">${a.airplaneGrade }</h2>
											</td>
											<td>${a.airplaneDeptime }</td>
											<td>-></td>
											<td>${a.airplaneArrtime }</td>
											<td>${a.airplanePrice }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					
				</div>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-black btn-lg py-3 btn-block">예매내역 확인</button>
					</div>
				</div>
			</div>
			</form>
		</div>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/custom.js"></script>
</body>

</html>