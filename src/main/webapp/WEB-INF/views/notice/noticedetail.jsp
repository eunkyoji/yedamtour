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
		<form id="frm" action="" method="post" enctype="multipart/form-data">
		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">공지사항 상세</h5>
							<!-- Table with stripped rows -->
							<div class="card">
								<img src="attech/notice/${n.noticeImg}" class="card-img-top" alt="...">
								<div class="card-body">
									<h5 class="card-title">${n.noticeTitle }</h5>
									<p>${n.noticeContent}</p>
								</div>
							</div>
							<!-- End Table with stripped rows -->
							<div align="right">
								<button type="button" class="btn btn-primary" onclick="noticeModify(${n.noticeId})">수정</button>
								<button type="button" class="btn btn-primary" onclick="noticeDelete(${n.noticeId})">삭제</button>
								<button type="button" class="btn btn-primary" onclick="location.href = 'noticelist.do'">목록</button>
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
	<script type="text/javascript">
	function noticeModify(id){
		console.log(id);
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