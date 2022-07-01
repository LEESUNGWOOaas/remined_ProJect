<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<style>

</style>
<div class="header"> 
	<h1 class="page-header">
		<small>Popup</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"><!-- form --></div>
			</div>
		</div>
		
		<div class="panel-body">
				
			<table class="table table-bordered">
				<colgroup>
					<col width="20%" />
					<col width="80%" />
				</colgroup>
			
				<tr>
					<th>Title</th>
					<td>${popupVO.title }</td>
				</tr>
				
				<tr>
					<th>ContentType</th>
					<td>${popupVO.contentType}</td>
				</tr>
				
				<tr>
					<th>InsertDate</th>
					<td>${popupVO.insertDate}</td>
				</tr>
				
				<tr>
					<th>View Size</th>
					<td>X : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${popupVO.width}
					Y : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${popupVO.height}</td>
				</tr>
				
			
				<tr>
					<th>View Location</th>
					<td>Width : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${popupVO.lotationX }
					&nbsp;&nbsp;&nbsp;Height : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${popupVO.lotationY }</td>
				</tr>
				
				
				<tr>
					<th>Contents</th>
					<td style="line-height: 1.5em">${popupVO.content }</td>
				</tr>
				
				<tr>
					<th>File</th>
					<td>
						<ul class="list-unstyled">
							<c:forEach var="item" items="${popupVO.fileList }">
								<li class="mb-5">
									<a class="bold" onclick="fnFileDown('${item.fileNoAES}')">${item.fileName }</a> &nbsp; 
									[${item.fileSizeMB } M]
								</li>
	                    	</c:forEach>
						</ul>
					</td>
				</tr>
				
				<tr>
					<th>Use Status</th>
					<td>${popupVO.useYn }</td>
				</tr>
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="수정" onclick="goForm(${popupVO.popupNo})"> 
                       <input type="button" class="btn btn-danger" value="삭제" onclick="del(${popupVO.popupNo})"> 
                       <input type="button" class="btn btn-default" value="목록으로" onclick="goList();"> 
				</div>
			</div>
				
		</div>
	</div>
</div>


<script>
$(function(){
	activeMenu('/admin/popup/popupList');
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("/admin/popup/popupList");
}


function goForm(popupNo){
	location.href='./popupForm?popupNo='+popupNo+'&'+window.location.search.substring(1);
}

function del(popupNo) {
	
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params = {
		"popupNo": popupNo
	}
	
	$.ajax({
		url : "./delete",
		type: 'post',
		data: params,
		dataType: 'json',
		success: function(response) {
			alert(response.msg);
			if(response.result){
				goList();
			}
		}
	}); 	
	
}
</script>


