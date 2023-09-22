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
							<h5 class="card-title">회원목록</h5>
							
							<!-- Table with stripped rows -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">회원아이디</th>
										<th scope="col">회원명</th>
										<th scope="col">연락처</th>
										<th scope="col">닉네임</th>
										<th scope="col">가입일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${members}" var="m">
									<tr>
										<th scope="row">${m.rownum }</th>
										<td>${m.memberId }</td>
										<td>${m.memberName }</td>
										<td>${m.memberPhone }</td>
										<td>${m.memberNickname }</td>
										<td>${m.memberRegist }</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

						</div>
					</div>

				</div>
			</div>
		</section>

	</main>
</body>
</html>