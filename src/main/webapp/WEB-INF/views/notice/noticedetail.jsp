<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="container">
	<main id="main" class="main">

		<!-- End Page Title -->
		<form id="frm" action="" method="post" enctype="multipart/form-data">
			<section class="section">
				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">공지사항</h5>
								<div class="card mb-3">
									<div class="row g-0">
										<c:choose>
											<c:when test="${empty n.noticeImg }">
											</c:when>
											<c:otherwise>
												<div class="col-md-4">
														<img src="attech/notice/${n.noticeImg}" class="img-fluid rounded-start" alt="...">
												</div>
											</c:otherwise>
										</c:choose>
										
										<div class="col-md-8">
											<div class="card-body">
												<h5 class="card-title">${n.noticeTitle }</h5>
												<p class="card-text">${n.noticeContent}</p>
											</div>
										</div>
									</div>
								</div>

								<div align="right">
									<button type="button" class="btn btn-primary"
										onclick="noticeModify(${n.noticeId})">수정</button>
									<button type="button" class="btn btn-primary"
										onclick="noticeDelete(${n.noticeId})">삭제</button>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'noticelist.do'">목록</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>
		</form>
		<form id="mform" action="noticemodify.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
		<form id="dform" action="noticedelete.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</main>
</div>
	<script type="text/javascript">
	function noticeModify(id){
		let form = document.getElementById("mform");
		form.noticeId.value = id;
		form.submit();
	}
	
	function noticeDelete(id){
		let form = document.getElementById("dform");
		form.noticeId.value = id;
		form.submit();
	}
	</script>
</body>
</html>