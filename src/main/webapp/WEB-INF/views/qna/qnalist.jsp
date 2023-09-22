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

		<!-- End Page Title -->

		<!-- F.A.Q Group 2 -->
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Q & A </h5>
				
				<div class="accordion accordion-flush" id="faq-group-2">
					<c:forEach items="${qnalists}" var="q">
					<div class="accordion-item">
						<h2 class="accordion-header">
							<button class="accordion-button collapsed"
								data-bs-target="#faqsTwo-1" type="button"
								data-bs-toggle="collapse"><span>${q.qnaTitle }</span></button>
						</h2>
						<div id="faqsTwo-1" class="accordion-collapse collapse"
							data-bs-parent="#faq-group-2">
							<div class="accordion-body">${q.qnaContent }</div>
						</div>
					</div>
					</c:forEach>
				</div>
				<div width="500px" align="right">
				<button type="button" class="btn btn-primary" onclick="location.href = 'qnawriteform.do'">글쓰기</button>
				</div>
			</div>
		</div>
		<!-- End F.A.Q Group 2 -->
	</main>
</body>
</html>