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
		<form id="frm" action="noticewriter.do" method="post" enctype="multipart/form-data">
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">공지사항 상세</h5>
							<!-- Table with stripped rows -->
							<div class="card">
								<img src="niceadmin/assets/img/${n.noticeImg}" class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">${n.noticeTitle }</h5>
									<textarea >${n.noticeContent }
									</textarea>
								</div>
							</div>
							<!-- End Table with stripped rows -->
							<div align="right">
								<button type="button" class="btn btn-primary" onclick="noticeModify(${n.noticeId})">수정</button>
								<button type="button" class="btn btn-primary" onclick="location.href = 'noticelist.do'">목록</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		</form>
		<form id="sform" action="noticemodify.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</main>
	<script type="text/javascript">
		let form = document.getElementById("sform");
		form.noticeId.value = id;
		form.submit();
	</script>
</body>
</html>