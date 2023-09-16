<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	<!-- ===============================================-->
	<!--    Document Title-->
	<!-- ===============================================-->
	<title><tiles:getAsString name="title" /></title>


	<!-- ===============================================-->
	<!--    Favicons-->
	<!-- ===============================================-->
	<link rel="apple-touch-icon" sizes="180x180" href="jadoo/public/assets/img/favicons/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="jadoo/public/assets/img/favicons/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="jadoo/public/assets/img/favicons/favicon-16x16.png">
	<link rel="shortcut icon" type="image/x-icon" href="jadoo/public/assets/img/favicons/favicon.ico">
	<link rel="manifest" href="jadoo/public/assets/img/favicons/manifest.json">
	<meta name="msapplication-TileImage" content="jadoo/public/assets/img/favicons/mstile-150x150.png">
	<meta name="theme-color" content="#ffffff">


	<!-- ===============================================-->
	<!--    Stylesheets-->
	<!-- ===============================================-->
	<link href="jadoo/public/assets/css/theme.css" rel="stylesheet" />

</head>

<body>


	<!-- ===============================================-->
	<!--    Main Content-->
	<!-- ===============================================-->
	<main class="main" id="top">
		<!-- menu start -->
		<tiles:insertAttribute name="header" />
		<!-- menu end -->
		<!-- body start-->
		<tiles:insertAttribute name="body" />
		<!-- body end -->



		<!-- ============================================-->
		<!-- <section> begin  footer start============================-->
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		<!-- <section> footer close ============================-->
		<!-- ============================================-->
	</main>
	<!-- ===============================================-->
	<!--    End of Main Content-->
	<!-- ===============================================-->




	<!-- ===============================================-->
	<!--    JavaScripts-->
	<!-- ===============================================-->
	<script src="jadoo/public/vendors/@popperjs/popper.min.js"></script>
	<script src="jadoo/public/vendors/bootstrap/bootstrap.min.js"></script>
	<script src="jadoo/public/vendors/is/is.min.js"></script>
	<script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
	<script src="jadoo/public/vendors/fontawesome/all.min.js"></script>
	<script src="jadoo/public/assets/js/theme.js"></script>

	<link
		href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&amp;family=Volkhov:wght@700&amp;display=swap"
		rel="stylesheet">

<script>
	$(document).ready(function () {
    $('.bxslider').bxSlider({
        auto: true, // 자동으로 애니메이션 시작
        speed: 500,  // 애니메이션 속도
        pause: 5000,  // 애니메이션 유지 시간 (1000은 1초)
        mode: 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
        autoControls: true, // 시작 및 중지버튼 보여짐
        pager: true, // 페이지 표시 보여짐
        captions: true, // 이미지 위에 텍스트를 넣을 수 있음
    });
});
</script>
</body>


</html>