<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
button{
	align: right;
}
</style>
<body>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Questions And Answers</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item">게시판관리</li>
					<li class="breadcrumb-item active">Q & A</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<!-- F.A.Q Group 2 -->
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Q & A </h5>
				
				<div class="accordion accordion-flush" id="faq-group-2">

					<div class="accordion-item">
						<h2 class="accordion-header">
							<button class="accordion-button collapsed"
								data-bs-target="#faqsTwo-1" type="button"
								data-bs-toggle="collapse">Cumque voluptatem recusandae
								blanditiis?</button>
						</h2>
						<div id="faqsTwo-1" class="accordion-collapse collapse"
							data-bs-parent="#faq-group-2">
							<div class="accordion-body">Ut quasi odit odio totam
								accusamus vero eius. Nostrum asperiores voluptatem eos nulla ab
								dolores est asperiores iure. Quo est quis praesentium aut
								maiores. Corrupti sed aut expedita fugit vero dolorem. Nemo
								rerum sapiente. A quaerat dignissimos.</div>
						</div>
					</div>
				</div>
				<div width="500px" align="right">
				<button type="button" class="btn btn-primary" onclick="location.href = 'qnawrite.do'">글쓰기</button>
				</div>
			</div>
		</div>
		<!-- End F.A.Q Group 2 -->
</body>
</html>