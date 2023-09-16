<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="colorlib">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Travel</title>

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
<!--
			CSS
			============================================= -->
<link rel="stylesheet" href="travelista/css/linearicons.css">
<link rel="stylesheet" href="travelista/css/font-awesome.min.css">
<link rel="stylesheet" href="travelista/css/bootstrap.css">
<link rel="stylesheet" href="travelista/css/magnific-popup.css">
<link rel="stylesheet" href="travelista/css/jquery-ui.css">
<link rel="stylesheet" href="travelista/css/nice-select.css">
<link rel="stylesheet" href="travelista/css/animate.min.css">
<link rel="stylesheet" href="travelista/css/owl.carousel.css">
<link rel="stylesheet" href="travelista/css/main.css">
</head>
<body>
	<!-- header start -->
	<tiles:insertAttribute name="header" />
	<!-- #header -->

	<!-- start banner Area -->
	<section class="banner-area relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div
				class="row fullscreen align-items-center justify-content-between">
				<div class="col-lg-6 col-md-6 banner-left">
					<h6 class="text-white">Away from monotonous life</h6>
					<h1 class="text-white">Magical Travel</h1>
					<p class="text-white">If you are looking at blank cassettes on
						the web, you may be very confused at the difference in price. You
						may see some for as low as $.17 each.</p>
					<a href="#" class="primary-btn text-uppercase">Get Started</a>
				</div>
				<div class="col-lg-4 col-md-6 banner-right">
					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="flight-tab" data-toggle="tab" href="#flight" role="tab"
							aria-controls="flight" aria-selected="true">Flights</a></li>
						<li class="nav-item"><a class="nav-link" id="hotel-tab"
							data-toggle="tab" href="#hotel" role="tab" aria-controls="hotel"
							aria-selected="false">Hotels</a></li>
						<li class="nav-item"><a class="nav-link" id="holiday-tab"
							data-toggle="tab" href="#holiday" role="tab"
							aria-controls="holiday" aria-selected="false">Holidays</a></li>
					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="flight" role="tabpanel"
							aria-labelledby="flight-tab">
							<form class="form-wrap">
								<input type="text" class="form-control" name="name"
									placeholder="From " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'From '"> <input type="text"
									class="form-control" name="to" placeholder="To "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'To '"> <input type="text"
									class="form-control date-picker" name="start"
									placeholder="Start " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Start '"> <input
									type="text" class="form-control date-picker" name="return"
									placeholder="Return " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Return '"> <input
									type="number" min="1" max="20" class="form-control"
									name="adults" placeholder="Adults "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Adults '"> <input
									type="number" min="1" max="20" class="form-control"
									name="child" placeholder="Child "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Child '"> <a href="#"
									class="primary-btn text-uppercase">Search flights</a>
							</form>
						</div>
						<div class="tab-pane fade" id="hotel" role="tabpanel"
							aria-labelledby="hotel-tab">
							<form class="form-wrap">
								<input type="text" class="form-control" name="name"
									placeholder="From " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'From '"> <input type="text"
									class="form-control" name="to" placeholder="To "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'To '"> <input type="text"
									class="form-control date-picker" name="start"
									placeholder="Start " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Start '"> <input
									type="text" class="form-control date-picker" name="return"
									placeholder="Return " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Return '"> <input
									type="number" min="1" max="20" class="form-control"
									name="adults" placeholder="Adults "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Adults '"> <input
									type="number" min="1" max="20" class="form-control"
									name="child" placeholder="Child "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Child '"> <a href="#"
									class="primary-btn text-uppercase">Search Hotels</a>
							</form>
						</div>
						<div class="tab-pane fade" id="holiday" role="tabpanel"
							aria-labelledby="holiday-tab">
							<form class="form-wrap">
								<input type="text" class="form-control" name="name"
									placeholder="From " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'From '"> <input type="text"
									class="form-control" name="to" placeholder="To "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'To '"> <input type="text"
									class="form-control date-picker" name="start"
									placeholder="Start " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Start '"> <input
									type="text" class="form-control date-picker" name="return"
									placeholder="Return " onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Return '"> <input
									type="number" min="1" max="20" class="form-control"
									name="adults" placeholder="Adults "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Adults '"> <input
									type="number" min="1" max="20" class="form-control"
									name="child" placeholder="Child "
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Child '"> <a href="#"
									class="primary-btn text-uppercase">Search Holidays</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start popular-destination Area -->

	<!-- End popular-destination Area -->


	<!-- Start price Area -->

	<!-- End price Area -->
	<tiles:insertAttribute name="body" />

	<!-- Start other-issue Area -->

	<!-- End other-issue Area -->


	<!-- Start testimonial Area -->

	<!-- End testimonial Area -->

	<!-- Start home-about Area -->

	<!-- End home-about Area -->


	<!-- Start blog Area -->

	<!-- End recent-blog Area -->

	<!-- start footer Area -->
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<!-- End footer Area -->

	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="travelista/js/jquery-ui.js"></script>
	<script src="travelista/js/easing.min.js"></script>
	<script src="travelista/js/hoverIntent.js"></script>
	<script src="travelista/js/superfish.min.js"></script>
	<script src="travelista/js/jquery.ajaxchimp.min.js"></script>
	<script src="travelista/js/jquery.magnific-popup.min.js"></script>
	<script src="travelista/js/jquery.nice-select.min.js"></script>
	<script src="travelista/js/owl.carousel.min.js"></script>
	<script src="travelista/js/mail-script.js"></script>
	<script src="travelista/js/main.js"></script>
</body>
</html>