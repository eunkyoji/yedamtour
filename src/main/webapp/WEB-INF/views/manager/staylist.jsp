<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img{
	width: 100px;
	height:80px;
}
</style>
</head>
<body>
	<c:set var="id" value='<%=(String) session.getAttribute("id")%>' />
	<section class="pt-5 pt-md-9">
		<div class="contact_section">
			<main id="main" class="main">
				<section class="section">
					<div class="row">
						<div class="col-lg-12">

							<div class="card">
								<div class="card-body">
									<h5 class="card-title" align="left">Stay List</h5>
									<select class="datatable-selector" name="categoryId" id="categoryId" onchange="categorySelect(this.value)">
										<option value="null">전체</option>
									    <option value="1">호텔/리조트</option>
									    <option value="2">펜션/풀빌라</option>
									    <option value="3">캠핑</option>
									</select>
									<!-- Table with stripped rows -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">번호</th>
												<th scope="col">이미지</th>
												<th scope="col">분류</th>
												<th scope="col">숙소명</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${empty list }">
													<tr>
														<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach items="${list}" var="s">
														<tr style="cursor: pointer"
															onclick="staySelect(${s.stayId}, ${s.categoryId })">
															<th scope="row">${s.rowN }</th>
															<c:choose>
																<c:when test="${empty s.stayImg }">
																	<td></td>
																</c:when>
																<c:otherwise>
																	<td><img
																		src="img/rooms/${s.stayImg}"></td>
																</c:otherwise>
															</c:choose>
															<td align="left">${s.categoryName}</td>
															<td>${s.stayName }</td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
									<div align="center">

										<ul class="pagination" style="text-align: center;">
											<li class="page-item"><a class="page-link"
												href="staylist.do?pageNum=${(endPage - 5)}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>

											<c:forEach var="i" begin="${startPage }" end="${endPage }">
												<li class="page-item"><a class="page-link"
													href="staylist.do?pageNum=${i}" id="btn${i }"
													onClick="clickEvent(${i})">${i}</a></li>
											</c:forEach>

											<li class="page-item"><a class="page-link"
												href="staylist.do?pageNum=${startPage + 5}"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>

									</div>
									<!-- End Table with stripped rows -->
									<c:choose>
										<c:when test="${not empty id }">
											<div align="right">
												<button type="button" class="btn btn-primary"
													onclick="location.href = 'staywriteform.do'">등록</button>
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
			</main>
		</div>
	</section>
	<form id="frm" action="staylist.do" method="post">
		<input type="hidden" id="categoryId" name="categoryId">
	</form>
	<form id="sform" action="staydetail.do" method="post">
		<input type="hidden" id="stayId" name="stayId">
	</form>

	<script>
		//게시글 상세조회
		
		function staySelect(id){
			let form = document.getElementById("sform");
			form.stayId.value = id;
			form.submit();
		}

		
		function categorySelect(value){
			
			categorySelected(value);
			
			let form = document.getElementById("frm");
			form.categoryId.value = value;
		}
		
		function categorySelected(cId){
			const el = document.getElementById('categoryId');  //select box
			const len = el.options.length; //select box의 option 갯수
		  	
		  	for (let i=0; i<len; i++){  
		  		
		  		if(el.options[i].value == value){
		    		el.options[i].selected = true;
		    	} else {
		    		el.options[i].selected = false;
		    	}

		  	}
		}
	</script>
</body>
</html>