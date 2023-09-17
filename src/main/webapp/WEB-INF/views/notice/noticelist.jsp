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

		<div class="pagetitle">
			<h1>게시판관리</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">게시판관리</li>
					<li class="breadcrumb-item active">공지사항</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">공지사항</h5>
							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">제목</th>
										<th scope="col">작성일</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>Brandon Jacob</td>
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