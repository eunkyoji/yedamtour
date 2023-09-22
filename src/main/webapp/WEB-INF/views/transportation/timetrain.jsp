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
			<div class="container" style="margin-top: 200px;">
				<div class="intro-excerpt" style="text-align: center">
					<h1>${date[0] }</h1>
				</div>
				<div class="row mb-5">
					<form class="col-md-12" method="post">
						<div class="site-blocks-table">
							<table class="table">
								<thead>
									<tr>
										<th class="product-name">등급</th>
										<th class="product-price">출발시간</th>
										<th class="product-arrow"></th>
										<th class="product-quantity">도착시간</th>
										<th class="product-total">가격</th>
									</tr>
								</thead>
								<tbody>
					<c:forEach items="${trains }" var="t">
									<tr>

										<td class="product-name">
											<h2 class="h5 text-black">${t.trainGrade }</h2>
										</td>
										<td>${t.trainDeptime }</td>
										<td>-></td>
										<td>${t.trainArrtime }</td>
										<td>${t.trainPrice }</td>
									</tr>								
						</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>			
			</div>
			<div class="container" style="margin-top: 200px;">
				<div class="intro-excerpt" style="text-align: center">
					<h1>${date[1] }</h1>
				</div>
				<div class="row mb-5">
					<form class="col-md-12" method="post">
						<div class="site-blocks-table">
							<table class="table">
								<thead>
									<tr>
										<th class="product-name">등급</th>
										<th class="product-price">출발시간</th>
										<th class="product-arrow"></th>
										<th class="product-quantity">도착시간</th>
										<th class="product-total">가격</th>
									</tr>
								</thead>
								<tbody>
					<c:forEach items="${trains }" var="t">
									<tr>

										<td class="product-name">
											<h2 class="h5 text-black">${t.trainGrade }</h2>
										</td>
										<td>${t.trainDeptime }</td>
										<td>-></td>
										<td>${t.trainArrtime }</td>
										<td>${t.trainPrice }</td>
									</tr>
						</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-black btn-lg py-3 btn-block"
							onclick="window.location='resulttrain.do'">예매내역 확인</button>
					</div>
				</div>
			</div>
		</div>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/tiny-slider.js"></script>
	<script src="js/custom.js"></script>
</body>

</html>