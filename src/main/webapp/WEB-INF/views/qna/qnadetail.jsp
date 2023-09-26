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
							<form id="frm" action="qnawrite.do" method="post" enctype="form-data">
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
								<textarea class="form-control" aria-describedby="basic-addon1" rows="20" id="qnaContent" name="qnaContent" readonly>${q.qnaContent }</textarea>
							</div>
							<c:choose>
								<c:when test="${author == 'Admin' }">
									<div class="input-group mb-3">
										<textarea class="form-control" aria-describedby="basic-addon1" rows="20" id="qnaContent" name="qnaContent"></textarea>
									</div>
								</c:when>
								<c:otherwise>
									
								</c:otherwise>
							</c:choose>
							<!-- End Quill Editor Full -->
							<div align="right">
								<c:choose>
									<c:when test="${author == 'Admin' }">
										<button type="submit" class="btn btn-primary" onclick="location.href = 'qnareply.do'">저장</button>
										<button type="reset" class="btn btn-primary" onclick="location.href = 'qnalist.do'">목록</button>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${q.qnaWriter == id }">
												<button type="submit" class="btn btn-primary" onclick="location.href = 'qnamodifyform.do'">수정</button>
												<button type="submit" class="btn btn-primary" onclick="location.href = 'qnadelete.do'">삭제</button>
												<button type="reset" class="btn btn-primary">취소</button>
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
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</div>
</section>
	<script type="text/javascript">

	</script>

</body>

</html>