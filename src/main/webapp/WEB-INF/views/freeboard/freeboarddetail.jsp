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


<body>
<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
<section class="pt-5 pt-md-9">
	<div class="contact_section">
		<main id="main" class="main">

			<!-- End Page Title -->
			<section class="section">
				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">자유게시판</h5>
								<div class="card mb-3">
									<div class="row g-0">
										<c:choose>
											<c:when test="${empty f.freeBoardImg }">
											</c:when>
											<c:otherwise>
												<div class="col-md-4">
													<img src="attech/freeboard/${f.freeBoardImg}"
														class="img-fluid rounded-start" alt="...">
												</div>
											</c:otherwise>
										</c:choose>
										<div class="col-md-8">
											<div class="card-body">
												<h5 class="card-title" align="left">${f.freeBoardTitle }</h5>
												<p class="card-text" align="left">${f.freeBoardContent}</p>
											</div>
										</div>
									</div>
								</div>

								<div align="right">
									<c:choose>
										<c:when test="${f.freeBoardWriter == id }">
											<button type="button" class="btn btn-primary"
												onclick="freeBoardModify(${f.freeBoardId})">수정</button>
											<button type="button" class="btn btn-primary"
												onclick="freeBoardDelete(${f.freeBoardId})">삭제</button>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'freeboardlist.do'">목록</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>
			<section class="section">
				
			</section>
			<form id="mform" action="freeboardmodifyform.do" method="post">
				<input type="hidden" id="freeBoardId" name="freeBoardId">
			</form>
			<form id="dform" action="freeboarddelete.do" method="post">
				<input type="hidden" id="freeBoardId" name="freeBoardId">
			</form>
		</main>
	</div>
</section>
	<script type="text/javascript">
	function freeBoardModify(id){
		let form = document.getElementById("mform");
		form.freeBoardId.value = id;
		form.submit();
	}
	
	function freeBoardDelete(id){
		let form = document.getElementById("dform");
		form.freeBoardId.value = id;
		form.submit();
	}
	</script>

</body>
</html>