<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<link href="webapp/css/board.css" rel="stylesheet">
<body>
	<!-- Favicons -->
	<link href="niceadmin/assets/img/favicon.png" rel="icon">
	<link href="niceadmin/assets/img/apple-touch-icon.png"
		rel="apple-touch-icon">

	<!-- Google Fonts -->
	<link href="https://fonts.gstatic.com" rel="preconnect">
	<link
		href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
		rel="stylesheet">

	<!-- Vendor CSS Files -->
	<link href="niceadmin/assets/vendor/remixicon/remixicon.css"
		rel="stylesheet">
	<link href="niceadmin/assets/vendor/simple-datatables/style.css"
		rel="stylesheet">

	<!-- Template Main CSS File -->
	<link href="niceadmin/assets/css/style.css" rel="stylesheet">
	<style>
body {
	background-color: white;
}

#navbarSupportedContent {
	border-top: none !important;
}
</style>
	<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
	<section class="pt-5 pt-md-9">
		<div class="contact_section">
			<main id="main" class="main">
				<section class="section">
					<div class="row">
						<div class="col-lg-12">

							<div class="card">
								<div class="card-body">
									<h5 class="card-title" align="left">Q & A</h5>
									<!-- Table with stripped rows -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">번호</th>
												<th scope="col">제목</th>
												<th scope="col">작성자</th>
												<th scope="col">작성일</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${empty qnalists }">
													<tr>
														<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach items="${qnalists}" var="q">
														<tr style="cursor: pointer"
															onclick="qnaSelect(${q.qnaId})">
															<th scope="row">${q.num }</th>
															<td align="left">${q.qnaTitle}</td>
															<td>${q.memberNickname }</td>
															<td>${q.qnaViewDate }</td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
									<div align="center">
									
										<ul class="pagination" style="text-align: center;">
											<c:choose>
												<c:when test="${pageCount.currentPage <=1}">
													<li/>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="qnalist.do?pageNum=${pageCount.currentPage-1}"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:otherwise>
											</c:choose>
											
											<c:forEach var="idx" begin="${pageCount.min }" end="${pageCount.max }">
												<c:choose>
													<%--전체페이지 수 보다 현재페이지번호가 크거나 같으면 페이지 넘어가지 않게--%>
													<c:when test="${idx==pageCount.currentPage}">
														<li class="page-item"><a class="page-link"
														href="qnalist.do?pageNum=${idx}" style="font-weight: bold;">${idx}</a></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
														href="qnalist.do?pageNum=${idx}">${idx}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:choose>
												<%--전체페이지 수 보다 현재페이지번호가 크거나 같으면 페이지 넘어가지 않게--%>
												<c:when test="${pageCount.currentPage>=pageCount.pageCnt}">
													<li></li>
												</c:when>
												<c:otherwise>
													<li class="page-item">
												        <a class="page-link" href="qnalist.do?pageNum=${pageCount.currentPage+1}" aria-label="Next">
												            <span aria-hidden="true">&raquo;</span>
												        </a>
												    </li>
												</c:otherwise>
											</c:choose>

										</ul>
									
									</div>
									<!-- End Table with stripped rows -->
									<c:choose>
										<c:when test="${not empty id }">
											<div align="right">
												<button type="button" class="btn btn-primary"
													onclick="location.href = 'qnawriteform.do'">글쓰기</button>
											</div>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>

								</div>
							</div>

						</div>
					</div>
				</section>
			</main>
		</div>
	</section>
	<form id="sform" action="qnadetail.do" method="post">
		<input type="hidden" id="qnaId" name="qnaId">
	</form>

	<script>
		//게시글 상세조회
		
		function qnaSelect(id){
			console.log(id + "==========================");
			let form = document.getElementById("sform");
			form.qnaId.value = id;
			form.submit();
		}
	</script>
</body>
</html>