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
	<main id="main" class="main">

		<!-- End Page Title -->
		<form id="frm" action="" method="post" enctype="multipart/form-data">
			<section class="section">
				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title">자유게시판</h5>
								<div class="card mb-3">
									<div class="row g-0">
										<c:if test="${not empty  f.freeboardThumb } ">
										<div class="col-md-4">
											<img src="attech/freeboard/${f.freeboardThumb}" class="img-fluid rounded-start" alt="...">
										</div>
										</c:if>
										<div class="col-md-8">
											<div class="card-body">
												<h5 class="card-title">${f.freeboardTitle }</h5>
												<p class="card-text">${f.freeboardContent}</p>
											</div>
										</div>
									</div>
								</div>

								<div align="right">
									<button type="button" class="btn btn-primary"
										onclick="freeBoardModify(${f.freeboardId})">수정</button>
									<button type="button" class="btn btn-primary"
										onclick="freeBoardDelete(${f.freeboardId})">삭제</button>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'freeboardlist.do'">목록</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>
		</form>
		<form id="mform" action="freeboardmodify.do" method="post">
			<input type="hidden" id="freeboardId" name="freeboardId">
		</form>
		<form id="dform" action="freeboarddelete.do" method="post">
			<input type="hidden" id="freeboardId" name="freeboardId">
		</form>
	</main>
	<script type="text/javascript">
	function freeBoardModify(id){
		let form = document.getElementById("mform");
		form.noticeId.value = id;
		form.submit();
	}
	
	function freeBoardDelete(id){
		let form = document.getElementById("dform");
		form.noticeId.value = id;
		form.submit();
	}
	</script>
</body>
</html>