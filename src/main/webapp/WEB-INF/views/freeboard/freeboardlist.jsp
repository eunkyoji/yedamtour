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
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">자유게시판</h5>
							<!-- Table with stripped rows -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">번호</th>
										<th scope="col"></th>
										<th scope="col">제목</th>
										<th scope="col">작성자</th>
										<th scope="col">작성일</th>
										<th scope="col">조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:choose>
										<c:when test="${empty freeboard }">
											<tr>
												<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach items="${freeboard}" var="f">
												<tr style="cursor:pointer" onclick="freeBoardSelect(${f.freeBoardId})">
													<th scope="row">${f.rownum }</th>
													<td>${f.freeBoardThumb}</td>
													<td>${f.freeBoardTitle}</td>
													<td>${f.freeBoardNicName }</td>
													<td>${f.freeBoardViewDate }</td>
													<td>${f.freeBoardHit }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

						<div align="right">
							<button type="button" class="btn btn-primary" onclick="location.href = 'freeboardwriteform.do'">글쓰기</button>
						</div>
						</div>
					</div>

				</div>
			</div>
		</section>
	</main>
	<form id="sform" action="freeboarddetail.do" method="post">
		<input type="hidden" id="freeBoardId" name="freeBoardId">
	</form>
	
	<style>
		//게시글 상세조회
		function freeBoardSelect(id){
			console.log(id + "==========================");
			let form = document.getElementById("sform");
			form.freeBoardId.value = id;
			form.submit();
		}
	</style>
</body>
</html>