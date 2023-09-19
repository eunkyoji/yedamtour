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
	<main id="main" class="main">
		<div id="app">
			<div class="pagetitle">
				<h1>게시판관리</h1>
				<nav>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item">게시판관리</li>
						<li class="breadcrumb-item">자유게시판</li>
						<li class="breadcrumb-item active">글쓰기</li>
					</ol>
				</nav>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">자유게시판</h5>

							<!-- Quill Editor Full -->
							<div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1">제목</span> <input
										type="text" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="noticeTitle"
										name="noticeTitle">
								</div>
							</div>
							<div class="input-group mb-3">
								<textarea class="form-control" aria-describedby="basic-addon1" align="left" rows="20" cols="113" id="noticeContent" name="noticeContent"></textarea>
							</div>
							<br>
							<!-- End Quill Editor Full -->
							<div align="right">
								<button type="submit" class="btn btn-primary"
									onclick="location.href = 'noticewrite.do'">저장</button>
								<button type="reset" class="btn btn-primary" onclick="reSet()">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<style>
		function reSet(){
			console.log("=================");
		}
	</style>
</body>

</html>