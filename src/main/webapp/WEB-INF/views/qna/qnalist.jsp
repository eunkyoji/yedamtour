<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<link href="webapp/css/board.css" rel="stylesheet">
<body>
<c:set var="id" value='<%=(String)session.getAttribute("id") %>' />
<section class="pt-5 pt-md-9">
<div class="contact_section">
	<main id="main" class="main">
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Q & A</h5>
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
												<tr style="cursor:pointer" onclick="qnaSelect(${q.qnaId})">
													<th scope="row">${q.rownum }</th>
													<td>${q.qnaTitle}</td>
													<td>${q.memberNicname }</td>
													<td>${q.qnaViewDate }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->
							<c:choose>
								<c:when test="${not empty id }">
									<div align="right">
										<button type="button" class="btn btn-primary" onclick="location.href = 'qnawriteform.do'">글쓰기</button>
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