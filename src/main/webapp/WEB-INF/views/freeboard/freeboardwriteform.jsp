<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="niceadmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="niceadmin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="niceadmin/assets/vendor/simple-datatables/style.css" rel="stylesheet">
<link href="niceadmin/assets/css/style.css" rel="stylesheet">
<style>
body{
	background-color: white;
}
#navbarSupportedContent{
	border-top: none !important;
}
</style>
<body>
<c:set var="id" value='<%=(String)session.getAttribute("id") %>' />
<section class="pt-5 pt-md-9">
<div class="contact_section">
	<main id="main" class="main">
		<div id="app">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title" align="left">자유게시판</h5>
							<form id="frm" action="freeboardwrite.do" method="post" enctype="multipart/form-data">
							<!-- Quill Editor Full -->
							<div>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1">제목</span> <input
										type="text" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="freeBoardTitle"
										name="freeBoardTitle">
										<span class="input-group-text" id="basic-addon1">이미지</span> 
										<input type="file" class="form-control" aria-label="Username"
										aria-describedby="basic-addon1" id="imgfile" name="imgfile" placeholder="jpg, png, gif">
								</div>
							</div>
							<div class="input-group mb-3">
								<textarea class="form-control" aria-describedby="basic-addon1" rows="20" id="freeBoardContent" name="freeBoardContent"></textarea>
							</div>
							<!-- End Quill Editor Full -->
							<div align="right">
								<button type="submit" class="btn btn-primary" onclick="location.href = 'freeboardwrite.do'">저장</button>
								<button type="reset" class="btn btn-primary" onclick="location.href = 'freeboardlist.do'">목록</button>
							</div>
							<input type="hidden" name="freeboardWriter" value="${id }">
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