<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="niceadmin/assets_mazer/images/favicon.svg" type="image/x-icon">
<link href="webapp/css/noticewrite.css" rel="stylesheet">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<body>
<c:set var="id" value='<%=(String)session.getAttribute("id") %>' />
<c:set var="author" value='<%=(String)session.getAttribute("author") %>' />
<section class="pt-5 pt-md-9">
<div class="contact_section">
	<main id="main" class="main">
		<div id="app">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Q & A</h5>
							<!-- Quill Editor Full -->
							<div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1">제목</span>
									<input type="text" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="qnaTitle" name="qnaTitle" value="${q.qnaTitle }" readonly>
									<span class="input-group-text" id="basic-addon1">작성자</span>
									<input type="text" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="qnaTitle" name="qnaTitle" value="${q.memberNickname }" readonly>
								</div>
							</div>
							<div class="input-group mb-3">
								<textarea class="form-control" aria-describedby="basic-addon1" rows="15" id="qnaContent" name="qnaContent" readonly>${q.qnaContent }</textarea>
							</div>
							<c:choose>
								<c:when test="${author == 'Admin'}">
									<c:choose>
										<c:when test="${not empty q.qnaReplay }">
											<form id="frm" action="qnareplayinsert.do" method="post" enctype="form-data">
												<div class="input-group mb-3">
													<textarea class="form-control" aria-describedby="basic-addon1" rows="10" id="qnaReplay" name="qnaReplay">${q.qnaReplay }</textarea>
												</div>
												<input type="hidden" id="qnaId" name="qnaId" value="${q.qnaId }">
												<input type="hidden" id="qnaReplayWriter" name="qnaReplayWriter" value="${id }">
											</form>
										</c:when>
										<c:otherwise>
											<form id="frm" action="qnareplayinsert.do" method="post" enctype="form-data">
												<div class="input-group mb-3">
													<textarea class="form-control" aria-describedby="basic-addon1" rows="10" id="qnaReplay" name="qnaReplay">${q.qnaReplay }</textarea>
												</div>
												<input type="hidden" id="qnaId" name="qnaId" value="${q.qnaId }">
												<input type="hidden" id="qnaReplayWriter" name="qnaReplayWriter" value="${id }">
											</form>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<div class="input-group mb-3">
										<textarea class="form-control" aria-describedby="basic-addon1" rows="10" id="qnaReplay" name="qnaReplay" readonly>${q.qnaReplay }</textarea>
									</div>
								</c:otherwise>
							</c:choose>
							<!-- End Quill Editor Full -->
							<div align="right">
								<c:choose>
									<c:when test="${author == 'Admin' }">
										<button type="submit" class="btn btn-primary" onclick="qnaReplayInsert()">저장</button>
										<button type="reset" class="btn btn-primary" onclick="location.href = 'qnalist.do'">목록</button>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${q.qnaWriter == id }">
												<button type="submit" class="btn btn-primary" onclick="qnaModifyform(${q.qnaId})">수정</button>
												<button type="submit" class="btn btn-primary" onclick="qnaDelete(${q.qnaId})">삭제</button>
												<button type="reset" class="btn btn-primary" onclick="location.href = 'qnalist.do'">목록</button>
											</c:when>
											<c:otherwise>
												<button type="reset" class="btn btn-primary" onclick="location.href = 'qnalist.do'">목록</button>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
								<input type="hidden" id="qnaWriter" name="qnaWriter" value="${id }">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<form id="mform" action="qnamodifyform.do" method="post">
		<input type="hidden" id="qnaId" name="qnaId">
	</form>
	<form id="dform" action="qnadelete.do" method="post">
		<input type="hidden" id="qnaId" name="qnaId">
		<input type="hidden" id="qnaWriter" name="qnaWriter" value="${id }">
	</form>
</div>
</section>
	<script type="text/javascript">
	function qnaModifyform(id){
		console.log("id === " + id);
		let form = document.getElementById("mform");
		form.qnaId.value = id;
		form.submit();
	}
	
	function qnaDelete(id){
		let form = document.getElementById("dform");
		form.qnaId.value = id;
		form.submit();
	}
	
	function qnaReplayInsert(){
		let form = document.getElementById("frm");
		form.submit();
	}
	</script>

</body>

</html>