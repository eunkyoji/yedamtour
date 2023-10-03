<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="webapp/css/board.css" rel="stylesheet">
<link href="niceadmin/assets/img/favicon.png" rel="icon">
<link href="niceadmin/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<link href="niceadmin/assets/css/style.css" rel="stylesheet">
<style>
body {
	background-color: white;
}
</style>
<body>
	<c:set var="author"
		value='<%=(String) session.getAttribute("author")%>' />
	<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
	<section class="pt-5 pt-md-9">
		<div class="contact_section">
			<main id="main" class="main">
				<section class="section">
					<div class="row">
						<div class="col-lg-12">

							<div class="card">
								<div class="card-body">
									<h5 class="card-title" align="left">공지사항</h5>
									<!-- Table with stripped rows -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">순번</th>
												<th scope="col" align="left">제목</th>
												<th scope="col" align="left">작성일</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${empty notices }">
													<tr>
														<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach items="${notices}" var="n">
														<tr style="cursor: pointer"
															onclick="noticeSelect(${n.noticeId})">
															<th scope="row">${n.num }</th>
															<td align="left">${n.noticeTitle }</td>
															<td>${n.noticeViewDate }</td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
									<div>
									<nav  style="text-align">
										<ul class="pagination" style="text-align: center;">
											<li class="page-item"><a class="page-link"
												href="noticelist.do?pageNum=${(endPage - 5)}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>

											<c:forEach var="i" begin="${startPage }" end="${endPage }">
												<li class="page-item"><a class="page-link"
													href="noticelist.do?pageNum=${i}">${i}</a></li>
											</c:forEach>

											<li class="page-item">
										        <a class="page-link" href="noticelist.do?pageNum=${startPage + 5}" aria-label="Next">
										            <span aria-hidden="true">&raquo;</span>
										        </a>
										    </li>
										</ul>
									</nav>
									</div>
									<!-- End Table with stripped rows -->
									<c:choose>
										<c:when test="${author=='Admin' && id == 'admin@ydtour.com'}">
											<div align="right">
												<button type="button" class="btn btn-primary"
													onclick="location.href = 'noticewriteform.do'">글쓰기</button>
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
	<form id="sform" action="noticedetail.do" method="post">
		<input type="hidden" id="noticeId" name="noticeId">
	</form>
	<script type="text/javascript">
	// Specify the normal table row background color
	//   and the background color for when the mouse 
	//   hovers over the table row.
	
	var TableBackgroundNormalColor = "#ffffff";
	var TableBackgroundMouseoverColor = "#f5f3f3";
	
	// These two functions need no customization.
	function ChangeBackgroundColor(row) { row.style.backgroundColor = TableBackgroundMouseoverColor; }
	function RestoreBackgroundColor(row) { row.style.backgroundColor = TableBackgroundNormalColor; }
	
	//게시글 상세조회
	function noticeSelect(id){
		let form = document.getElementById("sform");
		form.noticeId.value = id;
		form.submit();
	}
	</script>
</body>
</html>