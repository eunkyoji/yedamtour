<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
select{
float: right;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<main id="main" class="main">
		<!-- End Page Title -->

		<section class="section">
			<div class="row">
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">
							<h5 class="card-title">회원목록</h5>
							<select class="datatable-selector" name="author" id="author" onchange="authorSelect(this.value)">
								<option value=""></option>
								<option value="">전체</option>
							    <option value="Admin">관리자</option>
							    <option value="user">회원</option>
							</select>
							
							<!-- Table with stripped rows -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">회원아이디</th>
										<th scope="col">회원명</th>
										<th scope="col">연락처</th>
										<th scope="col">닉네임</th>
										<th scope="col">가입일</th>
										<th scope="col">권한</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${members}" var="m">
										<tr>
											<th scope="row">${m.rownum }</th>
											<td>${m.memberId }</td>
											<td>${m.memberName }</td>
											<td>${m.memberPhone }</td>
											<td>${m.memberNickname }</td>
											<td>${m.memberViewDate }</td>
											<c:choose>
												<c:when test="${m.memberAuthor eq 'Admin'}">
													<td>관리자</td>
												</c:when>
												<c:otherwise>
													<td>회원</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->
							<div align="right">
								<button type="button" class="btn btn-primary" onclick="location.href = 'signupform.do'">관리자등록</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		<form id="frm" action="memberlist.do" method="post">
			<input type="hidden" id="author" name="author">
		</form>
	</main>
	<script>
		function authorSelect(value){
			
			let form = document.getElementById("frm");
			form.author.value = value;
			form.submit();
		}
	</script>
</body>
</html>