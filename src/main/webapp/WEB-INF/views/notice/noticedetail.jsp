<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <link href="niceadmin/assets/img/favicon.png" rel="icon">
  <link href="niceadmin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<link href="niceadmin/assets/css/style.css" rel="stylesheet">
<style>
body{
	background-color: white;
}
</style>
<body>
<c:set var="id" value='<%=(String)session.getAttribute("id") %>' />
<section class="pt-5 pt-md-9">
<div class="contact_section">
	<main id="main" class="main">

		<!-- End Page Title -->
		<form id="frm" action="" method="post" enctype="multipart/form-data">
			<section class="section">
				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title" align="left">공지사항</h5>
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
												<h5 class="card-title" align="left">${n.noticeTitle }</h5>
												<p class="card-text" align="left">${n.noticeContent}</p>
											</div>
										</div>
									</div>
								</div>
								
								<c:choose>
									<c:when test="${id == 'admin@ydtour.com' }">
										<div align="right">
											<button type="button" class="btn btn-primary"
												onclick="noticeModifyform(${n.noticeId})">수정</button>
											<button type="button" class="btn btn-primary"
												onclick="noticeDelete(${n.noticeId})">삭제</button>
											<button type="button" class="btn btn-primary"
												onclick="location.href = 'noticelist.do'">목록</button>
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
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
		<form id="mform" action="noticemodifyform.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
		<form id="dform" action="noticedelete.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</main>
</div>
</section>
	<script type="text/javascript">
	function noticeModifyform(id){
		let form = document.getElementById("mform");
		form.noticeId.value = id;
		form.submit();
	}
	
	function noticeDelete(id){
		if(confirm("삭제하시겠습니까?")){
			let form = document.getElementById("dform");
			form.noticeId.value = id;
			form.submit();
		} else {
			return;
		}
	}
	</script>

</body>
</html>