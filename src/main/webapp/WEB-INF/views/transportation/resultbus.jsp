<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<form action="reservationregister.do" method="post">
	<div id="leftcard" class="col-lg-6 justify-content-center align-items-start" style="float: left;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/transportation/bus2.jpg" alt="booking" />
                  <div>                 
                  <h5 class="fw-medium">가는날</h5>
                    <h5 class="fw-medium">${startDate}</h5>
                    <p class="fs--1 mb-3 fw-medium">${startBus.busStart } -> ${startBus.busFinish }</p>
                    <p class="fs--1 mb-3 fw-medium">등급: ${startBus.busGrade }</p>
                    <p class="fs--1 mb-3 fw-medium">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium">가격: <fmt:formatNumber value="${startPrice }" pattern="#,###" />원</p>                           
                  </div>
                </div>
              </div>
              </div>
            <!-- 왕복 -->
            <div class="col-lg-6 justify-content-center align-items-start" style="display: inline-block;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/transportation/bus2.jpg" alt="booking" />
                  <div>                  
                  <h5 class="fw-medium">오는날</h5>
                     <h5 class="fw-medium">${finishDate }</h5>
                    <p class="fs--1 mb-3 fw-medium">${finishBus.busFinish } -> ${finishBus.busStart }</p>
                    <p class="fs--1 mb-3 fw-medium">등급: ${finishBus.busGrade }</p>
                    <p class="fs--1 mb-3 fw-medium">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium">가격: <fmt:formatNumber value="${finishPrice }" pattern="#,###" />원</p>
                    </div>               
                  </div>
                </div>
              </div>
            	<div class="row">
					<div class="col-md-12">
						<button type="submit" id="transReservation" class="btn btn-black btn-lg py-3 btn-block">예매 완료</button>
					</div>
				</div>
				<input type="hidden" id="categoryId" name="categoryId" value="13">
				<input type="hidden" id="startDate" name="startDate" value="${startDate}">
				<input type="hidden" id="busStartGrade" name="busStartGrade" value="${startBus.busGrade }">
				<input type="hidden" id="busStartPrice" name="busStartPrice" value="${startPrice }">
				<input type="hidden" id="finishDate" name="finishDate" value="${finishDate }">
				<input type="hidden" id="busFinishGo" name="busFinishGo" value="${finishBus.busFinish }">
				<input type="hidden" id="busFinishEnd" name="busFinishEnd" value="${finishBus.busStart }">
				<input type="hidden" id="busFinishGrade" name="busFinishGrade" value="${finishBus.busGrade }">
				<input type="hidden" id="busFinishPrice" name="busFinishPrice" value="${finishPrice }"> 
				
				<input type="hidden" id="busPerson" name="busPerson" value="${person }">
				<input type="hidden" id="totalPrice" name="totalPrice" value="${finishPrice + startPrice}">
				<input type="hidden" id="busStartGo" name="busStartGo" value="${startBus.busStart }">
				<input type="hidden" id="busStartEnd" name="busStartEnd" value="${startBus.busFinish }">
	</form>
</div>
</body>

</html>