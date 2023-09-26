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
<div id="container" style="margin: 200px 0 0 570px;">
	<div id="leftcard" class="col-lg-6 justify-content-center align-items-start" style="float: left;">
              <div class="card position-relative shadow" style="max-width: 370px;">               
                <div class="card-body p-3"> <img class="mb-4 mt-2 rounded-2 w-100" src="jadoo/public/assets/img/steps/booking-img.jpg" alt="booking" />
                  <div>
                  <h5 class="fw-medium">가는날</h5>
                    <h5 id="startDate" class="fw-medium">${startDate}</h5>
                    <p class="fs--1 mb-3 fw-medium"><span id="s1">${startAir.airplaneStart }</span> -> <span id="s2">${startAir.airplaneFinish }</span></p>
                    <p class="fs--1 mb-3 fw-medium">등급: ${startAir.airplaneGrade }</p>
                    <p class="fs--1 mb-3 fw-medium">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium">가격: <fmt:formatNumber value="${startPrice }" pattern="#,###" />원</p>     
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
                    <p class="fs--1 mb-3 fw-medium">인원: ${person }명</p>
                    <p class="fs--1 mb-3 fw-medium">가격: <fmt:formatNumber value="${finishPrice }" pattern="#,###" />원</p>    
                    </div>               
                  </div>
                </div>
              </div>
            	<div class="row">
					<div class="col-md-12">
						<button id="cart" class="btn btn-black btn-lg py-3 btn-block">장바구니 담기</button>
					</div>
				</div>
</div>
<script type="text/javascript">
let startDate = $('#startDate').text();
let s1 = $('#s1').text();
let s2 = $('#s2').text();
console.log(startDate);
let start = [];
start.push(s1);
start.push(s2);
/* start = [${startDate},
			   ${startAir.airplaneStart },
			   ${startAir.airplaneFinish },
			   ${startAir.airplaneGrade },
			   ${person },
			   ${startPrice },
			   ${finishDate },
			   ${finishAir.airplaneFinish },
			   ${finishAir.airplaneStart },
			   ${finishAir.airplaneGrade },
			   ${person },
			   ${finishPrice }]
			   ; */
$('#cart').on('click', function(){
	$.ajax({
		url: "reservationlist.do",
		method: 'post',
		date:{
			start: start
		},
		success: function(e){
			console.log(e);
		},
		error: function(e){
			console.log(e);
		}	
	})
})
	
	
	
		
</script>
</body>
</html>