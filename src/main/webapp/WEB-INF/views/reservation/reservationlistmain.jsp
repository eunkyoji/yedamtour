<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<main id="main" class="main">

		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">예약정보 리스트</h5>
							<!-- Table with stripped rows -->
							<!-- 예약테이블 조회후 출력하는 곳 -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">분류</th>
										<th scope="col">시작일</th>
										<th scope="col">종료일</th>
										<th scope="col">예약자</th>
										<th scope="col">예약등록일</th>
										<th scope="col">예약인원수</th>
										<th scope="col">메일전송</th>
									</tr>
								</thead>
								<c:forEach items="${vo}" var="r">
									<tbody>
										<tr>
											<!-- onmouseover="ChangeBackgroundColor(this)" onmouseout="RestoreBackgroundColor(this)" onclick="noticedetail.do" -->

											<th scope="row">${r.reservationId }</th>
											<td>${r.categoryName }</td>
											<td>x</td>
											<td>x</td>
											<td>${r.reservationWriterId }</td>
											<td>x</td>
											<td>${r.reservationPersonnel }</td>
											<c:if test="${r.sendCheck == 'no' }">
											<td><a class="sendEmail" style="cursor: pointer">메일전송하기</a></td>
											</c:if>
											<td hidden="hidden">${r.companyEmail }</td>
											<td hidden="hidden">${r.productName }</td>
											<td hidden="hidden">${r.reservationId }</td>
											<c:if test="${r.sendCheck == 'yes' }">
											<td>전송완료</td>
											</c:if>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							<!-- End Table with stripped rows -->

						</div>
					</div>
				</div>
			</div>
		</section>

	</main>
	<script>
		$('.sendEmail').on('click', function() {
			let sendEmail = $(this);
			let tr = sendEmail.parent().parent();
			let td = tr.children();
			let cEmail = td[8].textContent;
			let reservationId = td[10].textContent;
			console.log(cEmail);
			$.ajax({
				url : 'alertsendemail.do',
				method : 'post',
				data : {
					id : cEmail,
					reservId : reservationId
				},
				success : function(e) {
					alert("전송완료");
					td[7].innerText = "전송완료";
				},
				error : function(e) {
					console.log("전송실패");
				}
			})
		})
	</script>
</body>
</html>