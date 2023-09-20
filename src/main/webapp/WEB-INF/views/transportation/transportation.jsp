<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card{
display: inline-block;
float: right;
margin-top: 10px;
}

</style>
</head>
<body>
<section>
</section>
<section id="booking" style="margin-top: 200px;">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6" style="width: 550px;" >
              <div class="mb-4 text-start">
                <h5 class="text-secondary"></h5>
                <h3 class="fs-xl-10 fs-lg-8 fs-7 fw-bold font-cursive text-capitalize">목적지까지 편하게,<br> 3가지의 교통편 예약</h3>
              </div>
              <a href="bookbus.do"><div class="d-flex align-items-start mb-5">
                <div class="bg-primary me-sm-4 me-3 p-3" style="border-radius: 13px"> <img src="jadoo/public/assets/img/transportation/bus.png" width="22" alt="steps" /></div>
                <div class="flex-1">
                  <h5 class="text-secondary fw-bold fs-0">버스</h5>
                  <p>출발 / 도착 선택 -> <br class="d-none d-sm-block"></p>
                </div>
              </div></a>
              <a href="booktrain.do"><div class="d-flex align-items-start mb-5">
                <div class="bg-danger me-sm-4 me-3 p-3" style="border-radius: 13px"> <img src="jadoo/public/assets/img/transportation/train.png" width="22" alt="steps" /></div>
                <div class="flex-1">
                  <h5 class="text-secondary fw-bold fs-0">기차</h5>
                  <p>출발 / 도착 선택 -> <br class="d-none d-sm-block"></p>
                </div>
              </div></a>
              <a href="bookairplane.do"><div class="d-flex align-items-start mb-5">
                <div class="bg-info me-sm-4 me-3 p-3" style="border-radius: 13px"> <img src="jadoo/public/assets/img/transportation/airplane.png" width="22" alt="steps" /></div>
                <div class="flex-1">
                  <h5 class="text-secondary fw-bold fs-0">항공권</h5>
                  <p>출발 / 도착 선택 -> <br class="d-none d-sm-block"></p>
                </div>
              </div></a>
            </div>
	          </div>
	         <div class="card">
	         	<img src="jadoo/public/assets/img/transportation/travel.jpeg" width="700" alt="steps" />
	          	
	         </div>
        </div><!-- end of .container-->
      </section>
</body>
</html>