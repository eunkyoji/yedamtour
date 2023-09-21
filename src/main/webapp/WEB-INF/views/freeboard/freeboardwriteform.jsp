<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<main id="main" class="main">
		<div id="app">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">자유게시판</h5>
							<form id="frm" action="freeboardwrite.do" method="post" enctype="multipart/form-data">
							<!-- Quill Editor Full -->
							<div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1">제목</span> <input
										type="text" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="freeboardTitle"
										name="freeboardTitle" value="${n.noticeTitle }">
										<span class="input-group-text" id="basic-addon1">이미지</span> 
										<input type="file" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="imgfile" name="imgfile" placeholder="jpg, png, gif">
								</div>
							</div>
							<div class="input-group mb-3">
								<textarea class="form-control" aria-describedby="basic-addon1" rows="20" id="freeboardContent" name="freeboardContent"></textarea>
							</div>
							<!-- End Quill Editor Full -->
							<div align="right">
								<button type="submit" class="btn btn-primary" onclick="location.href = 'noticewrite.do'">저장</button>
								<button type="reset" class="btn btn-primary">취소</button>
								<button type="reset" class="btn btn-primary" onclick="location.href = 'noticelist.do'">목록</button>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
			<input type="hidden" name="freeboardWriter" value="hong@gmail.com">
		</div>
	</main>

	<script type="text/javascript">

	</script>

</body>

</html>