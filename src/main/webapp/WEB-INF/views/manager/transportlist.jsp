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
									<h5 class="card-title" align="left">Transport List</h5>
									<select class="datatable-selector" name="categoryId" id="categoryId" onchange="categorySelect(this.value)">
										<option value="null">전체</option>
									    <option value="11">버스</option>
									    <option value="12">기차</option>
									    <option value="13">비행기</option>
									</select>
									<!-- Table with stripped rows -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">번호</th>
												<th scope="col">분류</th>
												<th scope="col">출발지</th>
												<th scope="col">도착지</th>
												<th scope="col">출발시간</th>
												<th scope="col">도착시간</th>
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
															onclick="ticketSelect(${t.transportId}, ${t.categoryId })">
															<th scope="row">${t.rowN }</th>
															<td align="left">${t.categoryName}</td>
															<td align="left">${t.transportStart}</td>
															<td align="left">${t.transportFinish}</td>
															<td align="left">${t.depTime}</td>
															<td align="left">${t.arrTime}</td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
									<div align="center">

									 <ul class="pagination pagination-sm">
	               			
			               				<!-- 2. 이전버튼 활성화 여부 -->
			               				<c:if test="${pageVO.prev }">
		                        			<li><a href="transportlist.do?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
										</c:if>
										                        		
		                        		<!-- 1. 페이지번호 처리 -->
		                        		<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
			                        		<li  class="${pageVO.pageNum eq num ? 'active' : '' }">
			                        		<a href="transportlist.do?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
		                        		</c:forEach>
		                        		
		                        		<!-- 3. 다음버튼 활성화 여부 -->
		                        		<c:if test="${pageVO.next }">
		                        			<li><a href="transportlist.do?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
		                        		</c:if>
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
	<form id="frm" action="transportlist.do" method="post">
		<input type="hidden" id="categoryId" name="categoryId">
	</form>
	<form id="sform" action="staydetail.do" method="post">
		<input type="hidden" id="tId" name="tId">
		<input type="hidden" id="categoryId" name="categoryId">
	</form>

	<script>
		function ticketSelect(id, categoryId){
			let form = document.getElementById("sform");
			form.tId.value = id;
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