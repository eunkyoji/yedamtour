<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="niceadmin/assets_mazer/images/favicon.svg" type="image/x-icon">
</head>

<body>
	<div id="app">
		<div id="main">
			<div class="page-heading">
				<div class="pagetitle">
					<h1>게시판관리</h1>
					<nav>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.html">Home</a></li>
							<li class="breadcrumb-item">게시판관리</li>
							<li class="breadcrumb-item">공지사항</li>
							<li class="breadcrumb-item active">글쓰기</li>
						</ol>
					</nav>
				</div>
				<section class="section">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">공지사항</h4>
								</div>
								<div style="padding: 25px">
									<div class="input-group mb-3">
										<span class="input-group-text" id="basic-addon1">제목</span>
										<input type="text" class="form-control" aria-label="Username"
												aria-describedby="basic-addon1" id="noticeTitle", name="noticeTitle">
									</div>
								</div>
								<div class="card-body">
									<div id="editor" >
										<p id="noticeContent" name="noticeContent"></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<script
		src="niceadmin/assets_mazer/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="niceadmin/assets_mazer/js/bootstrap.bundle.min.js"></script>

	<script src="niceadmin/assets_mazer/vendors/ckeditor/ckeditor.js"></script>

	<script>
        ClassicEditor
            .create(document.querySelector('#editor'))
            .catch(error => {
                console.error(error);
            });
    </script>

	<script src="niceadmin/assets_mazer/assets/js/main.js"></script>
</body>

</html>