<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="webapp/css/noticelist.css" rel="stylesheet">
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
									<c:choose>
										<c:when test="${empty notices }">
											<tr>
												<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${notices}" var="n">
												<tr onmouseover="this.style.background='white'" onmouseout="this.style.background='#f5f3f3'"
													onclick="noticeselect(${n.noticeId})">
													<th scope="row">${n.rownum }</th>
													<td>${n.noticeTitle }</td>
													<td>${n.noticeViewDate }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

							<div align="right">
								<button type="button" class="btn btn-primary" onclick="location.href = 'noticewriteform.do'">글쓰기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	
	</main>
	<form id="sform" action="noticedetails.do" method="post">
		<input type="hidden" id="noticeId" name="noticeId">
	</form>
	<script type="text/javascript">
	var TableBackgroundNormalColor = "#ffffff";
	var TableBackgroundMouseoverColor = "#f5f3f3";
	
	// These two functions need no customization.
	function ChangeBackgroundColor(row) { row.style.backgroundColor = TableBackgroundMouseoverColor}
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