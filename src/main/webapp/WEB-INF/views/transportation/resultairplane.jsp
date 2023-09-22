<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#leftcard{
width: 400px;
}
</style>
</head>
<body>
<!-- 편도 -->
<div id="container" style="margin: 200px 0 0 570px;">
	<div id="leftcard" class="col-lg-6 justify-content-center align-items-start" style="float: left;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/steps/booking-img.jpg" alt="booking" />
                  <div>
                  <h5 class="fw-medium">가는날</h5>
                    <h5 class="fw-medium">${startDate}</h5>
                    <p class="fs--1 mb-3 fw-medium">${startAir.airplaneStart } -> ${startAir.airplaneFinish }</p>
                    <p class="fs--1 mb-3 fw-medium">등급: ${startAir.airplaneGrade }</p>
                    <p class="fs--1 mb-3 fw-medium">인원: ${startAir.airplanePerson }</p>
                    <p class="fs--1 mb-3 fw-medium">가격: ${startAir.airplanePrice }</p>     
                  </div>
                </div>
              </div>
              </div>
            <!-- 왕복 -->
            <div class="col-lg-6 justify-content-center align-items-start" style="display: inline-block;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/steps/booking-img.jpg" alt="booking" />
                  <div>
                  <h5 class="fw-medium">오는날</h5>
                     <h5 class="fw-medium">${finishDate }</h5>
                    <p class="fs--1 mb-3 fw-medium">${finishAir.airplaneFinish } -> ${finishAir.airplaneStart }</p>
                    <p class="fs--1 mb-3 fw-medium">등급: ${finishAir.airplaneGrade }</p>
                    <p class="fs--1 mb-3 fw-medium">인원: ${finishAir.airplanePerson }</p>
                    <p class="fs--1 mb-3 fw-medium">가격: ${finishAir.airplanePrice }</p>
                    </div>               
                  </div>
                </div>
              </div>
            	<div class="row">
					<div class="col-md-12">
						<button class="btn btn-black btn-lg py-3 btn-block"
							onclick="window.location='resultbus.do'">장바구니 담기</button>
					</div>
				</div>
</div>
</body>
</html>