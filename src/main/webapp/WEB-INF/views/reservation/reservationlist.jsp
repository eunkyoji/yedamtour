<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
								<tbody>
									<tr onmouseover="ChangeBackgroundColor(this)" onmouseout="RestoreBackgroundColor(this)" onclick="noticedetail.do">
										<th scope="row">1</th>
										<td>Brandon Jacob</td>
										<td>Designer</td>
										<td>Designer</td>
										<td>Designer</td>
										<td>Designer</td>
										<td>Designer</td>
										<td>Designer</td>
									</tr>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

						<div align="right">
							<button type="button" class="btn btn-primary" onclick="location.href = 'noticewrite.do'">글쓰기</button>
						</div>
						</div>
					</div>

				</div>
			</div>
		</section>

	</main>
</body>
</html>