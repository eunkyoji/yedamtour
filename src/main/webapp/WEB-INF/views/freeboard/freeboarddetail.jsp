<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <link href="niceadmin/assets/img/favicon.png" rel="icon">
  <link href="niceadmin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<link href="niceadmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="niceadmin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="niceadmin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="niceadmin/assets/vendor/quill/quill.snow.css" rel="stylesheet">

<link href="niceadmin/assets/css/style.css" rel="stylesheet">
<style>
body{
	background-color: white;
}
.input-form {
    display: block;
    width: 100%;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: var(--bs-body-color);
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    background-color: var(--bs-body-bg);
    background-clip: padding-box;
    border: var(--bs-border-width) solid var(--bs-border-color);
    border-radius: var(--bs-border-radius);
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
h6{
	font-weight: bold;
}
input{
	text-align: left !important;
	background: white;
}
#navbarSupportedContent{
	border-top: none !important;
}

#replayregist{
    display: flex;
}

#replayContent {
    display: flex !important;
    flex-direction: column !important;
}

#delete{
	font-size: 5px;
	color: #abadaf;
    text-decoration: underline;
}
</style>
<body>
<c:set var="id" value='<%=(String)session.getAttribute("id") %>' />
<c:set var="author" value='<%=(String)session.getAttribute("author") %>' />
<section class="pt-5 pt-md-9">
<div class="contact_section">
	<main id="main" class="main">

		<!-- End Page Title -->
		
			<section class="section">
				<div class="row">
					<div class="col-lg-12">

						<div class="card">
							<div class="card-body">
								<h5 class="card-title" align="left">자유게시판</h5>
								<div class="card mb-3">
									<div class="row g-0">
										<c:choose>
											<c:when test="${empty f.freeBoardImg }">
											</c:when>
											<c:otherwise>
												<div class="col-md-4">
													<img src="attech/freeboard/${f.freeBoardImg}"
														class="img-fluid rounded-start" alt="...">
												</div>
											</c:otherwise>
										</c:choose>
										<div class="col-md-8">
											<div class="card-body">
												<h5 class="card-title" align="left">${f.freeBoardTitle }</h5>
												<p class="card-text" align="left">${f.freeBoardContent}</p>
											</div>
										</div>
									</div>
								</div>

								<div align="right">
									<c:choose>
										<c:when test="${f.freeBoardWriter == id || author == 'Admin'}">
											<c:choose>
												<c:when test="${author == 'Admin'}">
													<button type="button" class="btn btn-primary"
														onclick="freeBoardDelete(${f.freeBoardId})">삭제</button>
												</c:when>
												<c:otherwise>
													<button type="button" class="btn btn-primary"
														onclick="freeBoardModify(${f.freeBoardId})">수정</button>
													<button type="button" class="btn btn-primary"
														onclick="freeBoardDelete(${f.freeBoardId})">삭제</button>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>
									<button type="button" class="btn btn-primary"
										onclick="location.href = 'freeboardlist.do'">목록</button>
								</div>
							</div>
						</div>
						<c:if test="${not empty id }">
						 <form id="frm" action="freeboardreplayregist.do" method="post" enctype="form-data">
							<div id="replayregist">
			                    <input type="text" class="input-form" style="width: 80%" id="replayConent" name="replayContent">&nbsp;&nbsp;<button type="button" class="btn btn-primary" id="regist">등록</button>
			                    <input type="hidden" id="replayWriter" name="replayWriter" value=${id }>
			                    <input type="hidden" id="freeBoardId" name="freeBoardId" value=${f.freeBoardId }>
			                    <input type="hidden" id="memberNickname" name="memberNickname" value=${f.freeBoardNicname }>
			                </div>
		                </form>
		                </c:if>
		               	<div>
							<br>
						</div>
		                <div id="replayrow">
		                	<div id="replay" style="display:none;">
		                		<h6 align="left"></h6>
		                		<input type="text" size="100px" style="text-align:left; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" id="replayContent"
		                			name="replayContent" disabled>
		                		<input type="hidden" id="replayId" name="replayId"  style="text-align:left;">
		                	</div>
		                </div>
					</div>
				</div>
			</section>
		
		<form id="mform" action="freeboardmodify.do" method="post">
			<input type="hidden" id="freeBoardId" name="freeBoardId">
		</form>
		<form id="dform" action="freeboarddelete.do" method="post">
			<input type="hidden" id="freeBoardId" name="freeBoardId">
		</form>
		<form id="rform" action="freeboardreplayregist.do" method="post">
			<input type="hidden" id="freeBoardId" name="freeBoardId">
		</form>
	</main>
</div>

</section>
	<script type="text/javascript">
	function freeBoardModify(id){
		let form = document.getElementById("mform");
		form.freeBoardId.value = id;
		form.submit();
	}
	
	function freeBoardDelete(id){
		if(confirm("삭제하시겠습니까?") == true){
			let form = document.getElementById("dform");
			form.freeBoardId.value = id;
			form.submit();
		} else {
			return;
		}
	}
	
	replayListCall();
	
	function replayListCall(){
	
		$.ajax({
	         url:"freeboardreplaylist.do?freeBoardId=" + ${f.freeBoardId},
	         type:"post",
	         datatype:"html",
	         success:function(data){
	        	 console.log(data.length);
				for( let i = 0; i < data.length; i++ ){
		   		 	let replayId = data[i].replayId;
		   		 	let clone = $('#replay').clone();
		   		 	
		   		 	let replayWriter = data[i].replayWriter;
		            let id = "${id}";
		            clone.css('display', 'block');
		            if( id == replayWriter || id == 'admin@ydtour.com'){
		            	clone.find('h6').text(data[i].memberNickname)
		            	.append(`&nbsp;&nbsp;<span id='delete' style="cursor:pointer;">삭제</span>`)
		            	.attr('onclick', 'replayDelete('+data[i].replayId+')');
		            } else {
		            	clone.find('h6').text(data[i].memberNickname);
		            }
		            				
		            clone.find('#replayContent').val(data[i].replayContent);
		            clone.find('#replayId').val(data[i].replayId);
		            $('#replayrow').append(clone);
		            //$('#replay:eq('+i+')').attr('id', 'replay'+replayId);
		            $('#replay').attr('id', 'replay'+replayId);
		       }
	         }   
	      })
	}

	
	$('#regist').on('click', function (){
		console.log("");
		
		let content = $('input[name=replayContent]').val();
		let boardId = "${f.freeBoardId}";
		let writerId= "${id}";
		let nickname= $('input[name=memberNickname]').val();
		$.ajax({
	         url:"freeboardreplayregist.do",
	         type:"post",
	         data:{freeBoardId: boardId, replayContent: content, replayWriter:writerId, memberNickname: nickname},
	         success:function(e){
	        	viewload( freeBoardId, replayContent, replayWriter, memberNickname);
	        	$('#replayContent').val("");
	        	location.reload();
	        	alert("댓글이 등록되었습니다.");
	         },
	         error: function(e){
	        	 alert("댓글 등록이 실패되었습니다.")
	         }
	      })
	      return false;
	})
	
	function viewload(freeBoardId, replayContent, replayWriter, memberNickname){
		 let clone = $('#replay').clone();
        
         clone.find('h6').text(memberNickname).append(`&nbsp;&nbsp;<span id='delete'>삭제</span>`);
         clone.find('#replayContent').val(replayContent);
         clone.find('#replayId').val(replayId);
         $('#replayrow').append(clone);
	}
	
	function replayDelete(replayId){
		console.log("replayId :: " + replayId);
		if(confirm("삭제하시겠습니까?") ){
			console.log("삭제???");	
			$.ajax({
			         url:"freeboardreplaydelete.do?freeBoardId="+${f.freeBoardId}+"&replayId="+replayId,
			         type:"post",
			         datatype:"html",
			         success:function(e){
			        	//$('#replay').detach();
			        	//$('#replay'+replayId).detach();
			        	$('#replayId'+replayId).detach();
			        	location.reload();
			         },
			         error: function(e){
			        	 alert("댓글 삭제가 실패되었습니다.")
			         }
			      })
		} else {
			return;
		}
	}

	</script>

</body>
</html>