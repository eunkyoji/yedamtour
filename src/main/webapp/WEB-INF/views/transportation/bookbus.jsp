<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<title>Places &mdash; Free HTML5 Bootstrap 4 Theme by ProBootstrap.com</title>
		<meta name="description" content="Free Bootstrap 4 Theme by ProBootstrap.com">
		<meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
 <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

	<link rel="stylesheet" href="assetsbook/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="jadoo/public/assetsbook/css/animate.css">
    <link rel="stylesheet" href="jadoo/public/assetsbook/fonts/ionicons/css/ionicons.min.css">
    
    <link rel="stylesheet" href="assetsbook/css/owl.carousel.min.css">
    
    <link rel="stylesheet" href="assetsbook/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="assetsbook/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="jadoo/public/assetsbook/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="assetsbook/css/select2.css">
    

    <link rel="stylesheet" href="jadoo/public/assets-book/css/helpers.css">
    <link rel="stylesheet" href="jadoo/public/assets-book/css/style.css">
</head>
<body>
<section class="probootstrap-cover overflow-hidden relative"  style="margin-top: 200px;" data-stellar-background-ratio="0.5"  id="section-home">
      
<div class="container">
 <div class="row mt-5">
          <div class="col">
           <img src="jadoo/public/assetsbook/images/bus.jpg"  alt="steps" style="width: 650px;"/></div>
          <div class="col probootstrap-animate">
            <form id="search" action="timebus.do" class="probootstrap-form">
              <div class="form-group">
                <div class="row mb-3">
                  <div class="col-md">
                    <div class="form-group">
                      <label for="id_label_single">출발지</label>
                      <label for="id_label_single" style="width: 100%;">
                        <select name="start" class="js-example-basic-single js-states form-control" id="start" style="width: 100%;">                        
                          <option value="서울">서울</option>
                          <option value="광주">광주</option>
                          <option value="대전복합">대전복합</option>
                          <option value="동대구">동대구</option>
                        </select>
                      </label>
                    </div>
                  </div>
                  <div class="col-md">
                    <div class="form-group">
                      <label for="id_label_single2">도착지</label>
                      <div class="probootstrap_select-wrap">
                        <label for="id_label_single2" style="width: 100%;">
                        <select name="finish" class="js-example-basic-single js-states form-control" id="finish" style="width: 100%;">                    
                          <option value="서울">서울</option>
                         <option value="광주">광주</option>
                          <option value="대전복합">대전복합</option>
                          <option value="동대구">동대구</option>                          
                        </select>
                      </label>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- END row -->
                </div>
                <!-- END row -->
                <div class="row mb-5">
                  <div class="col-md">
                    <div class="form-group">
                      <label for="probootstrap-date-departure">가는날</label>
                      <div class="probootstrap-date-wrap">                     
                        <input type="text" id="probootstrap-date-departure" class="form-control" name="startDate" placeholder="">
                      </div>
                    </div>
                  </div>
                  <div class="col-md">
                    <div class="form-group">
                      <label for="probootstrap-date-arrival">오는날</label>
                      <div class="probootstrap-date-wrap">                       
                        <input type="text" id="probootstrap-date-arrival" class="form-control" name="finishDate" placeholder="">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-md">
                    <div class="form-group">
                      <label for="id_label_single">인원</label>
                      <label for="id_label_single" style="width: 100%;">
                        <select class="js-example-basic-single js-states form-control" id="id_label_single" style="width: 100%;">                       
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                          <option value="6">6</option>
                          <option value="7">7</option>
                          <option value="8">8</option>
                          <option value="9">9</option>
                          <option value="10">10</option>                         
                        </select>
                      </label>
                    </div>
                  </div>                 
                <div class="row">
                  <div class="col-md">
                    <label for="round" class="mr-5"><input type="radio" id="round" name="direction">  왕복</label>
                    <label for="oneway"><input type="radio" id="oneway" name="direction">  편도</label>
                  </div>
                  <div class="col-md">
                    <a href="#"><input type="submit" value="Submit" class="btn btn-primary btn-block"></a>
                    <a href="#"></a>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      
      <script type="text/javascript">
      function searchList(){ // ajax post 방식
  		let form = document.getElementById("search");
  		let start = form.start.value;
  		let finish = form.finish.value;
  		//const formData = new FormData(form); // 자바스크립트 FormData class
  		//let payload = formData;
  		let payload = "start=" + start + "&finish=" + finish;
  		let url = "timebus.do";
  		fetch(url,{
  			method: "POST",
  			headers: {'Content-Type': 'application/x-www.form-urlencoded'},
  			body: payload
  		}).then(response=>response.json())
  		  .then(json=>htmlViews(json));
  	}
      </script>
      
    <script src="jadoo/public/assetsbook/js/jquery.min.js"></script>
    
    <script src="jadoo/public/assetsbook/js/popper.min.js"></script>
    <script src="jadoo/public/assetsbook/js/bootstrap.min.js"></script>
    <script src="jadoo/public/assetsbook/js/owl.carousel.min.js"></script>

    <script src="jadoo/public/assetsbook/js/bootstrap-datepicker.js"></script>
    <script src="jadoo/public/assetsbook/js/jquery.waypoints.min.js"></script>
    <script src="jadoo/public/assetsbook/js/jquery.easing.1.3.js"></script>

    <script src="jadoo/public/assetsbook/js/select2.min.js"></script>

    <script src="jadoo/public/assetsbook/js/main.js"></script>
    </section>    
</body>
</html>