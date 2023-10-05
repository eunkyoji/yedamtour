<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
									<h5 class="card-title" align="left">Ticket List</h5>
									<select class="datatable-selector" name="categoryId" id="categoryId" onchange="categorySelect(this.value)">
										<option value="null">전체</option>
									    <option value="21">아쿠아리움</option>
									    <option value="22">테마파크</option>
									    <option value="23">워터파크</option>
									</select>
									<!-- Table with stripped rows -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">번호</th>
												<th scope="col">이미지</th>
												<th scope="col">이미지</th>
												<th scope="col">분류</th>
												<th scope="col">장소명</th>
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
													<c:forEach items="${list}" var="t">
														<tr style="cursor: pointer"
															onclick="ticketSelect(${t.ticketId}, ${t.categoryId })">
															<th scope="row">${t.rowN }</th>
															<c:choose>
																<c:when test="${not empty img }">
																	<c:choose>
																		<c:when test="${categoryId == '21' }">
																			<td><img
																				src="ticket/img/aquarium/${t.img}"></td>
																		</c:when>
																		<c:when test="${categoryId == '22' }">
																			<td><img
																				src="ticket/img/themepark/${t.img}"></td>
																		</c:when>
																		<c:when test="${categoryId == '23' }">
																			<td><img
																				src="ticket/img/waterpark/${t.img}"></td>
																		</c:when>
																		
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<td></td>
																</c:otherwise>
															</c:choose>
															<td align="left">${t.categoryId}</td>
															<td align="left">${t.categoryName}</td>
															<td>${t.ticketName }</td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
									<div align="center">

										<ul class="pagination" style="text-align: center;">
											<li class="page-item"><a class="page-link"
												href="ticketlist.do?pageNum=${(endPage - 5)}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>

											<c:forEach var="i" begin="${startPage }" end="${endPage }">
												<li class="page-item"><a class="page-link"
													href="ticketlist.do?pageNum=${i}" id="btn${i }"
													onClick="clickEvent(${i})">${i}</a></li>
											</c:forEach>

											<li class="page-item"><a class="page-link"
												href="ticketlist.do?pageNum=${startPage + 5}"
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
		<input type="hidden" id="categoryId" name="categoryId">
	</form>

	<script>
		function ticketSelect(id, categoryId){
			let form = document.getElementById("sform");
			form.stayId.value = id;
			form.categoryId.value = categoryId;
			form.submit();
		}
		
		function categorySelect(value){
			const el = document.getElementById('categoryId');  //select box
			const len = el.options.length; //select box의 option 갯수
		  	
		  	for (let i=0; i<len; i++){  
		  		if(el.options[i].value == value){
		    		el.options[i].selected = true;
		    	} else {
		    		el.options[i].selected = false;
		    	}
		  	}
			
			
			let form = document.getElementById("frm");
			form.categoryId.value = value;
			form.submit();
		}
	</script>
</body>
</html>