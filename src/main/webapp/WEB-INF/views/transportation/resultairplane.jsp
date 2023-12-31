<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
#leftcard{
width: 400px;
}
</style>
</head>
<body>
<!-- 편도 -->
<form action="reservationregister.do" class="col-md-12" method="post">
<input type="hidden" id="categoryId" name="categoryId" value="13">
	<div id="container" style="margin: 200px 0 0 570px;">
		<div id="leftcard" class="col-lg-6 justify-content-center align-items-start" style="float: left;">
        	<div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/transportation/airplane2.jpg" alt="booking" />
                  <div>
                  	<h5 class="fw-medium">가는날</h5>
                    <h5 id="startDate" class="fw-medium">${startDate}</h5>
                    <p class="fs--1 mb-3 fw-medium"><span id="start">${startAir.airplaneStart }</span> -> <span id="finish">${startAir.airplaneFinish }</span></p>
                    <p class="fs--1 mb-3 fw-medium">시간: <span id="startDep">${startAir.airplaneDeptime }</span> ~ <span id="startArr">${startAir.airplaneArrtime }</span></p>
                    <p class="fs--1 mb-3 fw-medium" id="startGrade">등급: ${startAir.airplaneGrade }</p>
                    <p class="fs--1 mb-3 fw-medium" id="person">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium" id="startPrice">가격: <fmt:formatNumber value="${startPrice }" pattern="#,###" />원</p>     
                  </div>
                </div>
            </div>
         </div>
            <!-- 왕복 -->
            <div class="col-lg-6 justify-content-center align-items-start" style="display: inline-block;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/transportation/airplane2.jpg" alt="booking" />
                  <div>
                    <h5 class="fw-medium">오는날</h5>
                    <h5 id="finishDate" class="fw-medium">${finishDate }</h5>
                    <p class="fs--1 mb-3 fw-medium"><span id="finish">${finishAir.airplaneFinish }</span> -> <span id="start">${finishAir.airplaneStart }</span></p>
                     <p class="fs--1 mb-3 fw-medium">시간: <span id="finishDep">${finishAir.airplaneDeptime }</span> ~ <span id="finishArr">${finishAir.airplaneArrtime }</span></p>
                    <p class="fs--1 mb-3 fw-medium" id="finishGrade">등급: ${finishAir.airplaneGrade }</p>
                    <p class="fs--1 mb-3 fw-medium" id="person">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium" id="finishPrice">가격: <fmt:formatNumber value="${finishPrice }" pattern="#,###" />원</p>    
                    </div>               
                  </div>
                </div>
              </div>
        <div class="row">
			<div class="col-md-12">
				<button type="button" class="btn btn-black btn-lg py-3 btn-block"	onclick="reservationregister.do">예매 완료</button>
			</div>
		</div>
	</div>
	<input type="hidden" id="startDate" name="startDate" value="${startDate}">
				<input type="hidden" id="airplaneStartGo" name="airplaneStartGo" value="${startAirplane.airplaneStart }">
				<input type="hidden" id="airplaneStartEnd" name="busStartEnd" value="${startAirplane.airplaneFinish }">
				<input type="hidden" id="airplaneStartGrade" name="busStartGrade" value="${startAirplane.airplaneGrade }">
				<input type="hidden" id="airplanePerson" name="busPerson" value="${person }">
				<input type="hidden" id="airplaneStartPrice" name="busStartPrice" value="${startPrice }">
				<input type="hidden" id="finishDate" name="finishDate" value="${finishDate }">
				<input type="hidden" id="airplaneFinishGo" name="busFinishGo" value="${finishAirplane.airplaneFinish }">
				<input type="hidden" id="airplaneFinishEnd" name="busFinishEnd" value="${finishAirplane.airplaneStart }">
				<input type="hidden" id="airplaneFinishGrade" name="busFinishGrade" value="${finishAirplane.airplaneGrade }">
				<input type="hidden" id="airplaneFinishPrice" name="busFinishPrice" value="${finishPrice }">
</form>
</body>


</html>