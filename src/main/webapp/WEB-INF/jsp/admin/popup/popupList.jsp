<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

    
<div class="header"> 
	<h1 class="page-header">
		 <small>Popup</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="row mb-10 ">
		<div class="col-sm-12 text-right">

			 <a href="popupForm" class="btn btn-sm btn-primary">등록</a><br/>
		</div>
	</div>
	
	<div class="panel panel-default">
		
		<div class="panel-body">
			
			<form id="searchForm" action="list">
			<div class="row mb-10 ">
				<div class="col-sm-6 pt-10">
					전체 <span class="text-red" style="color:red">${pageVO.totSize }</span>건
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">
					<div class="input-group">
						<div class="input-group-addon">
							<select name="searchType">						
								<option value="title" <c:if test="${popupVO.searchType eq 'title'}">selected</c:if>>제목</option>
								<option value="content" <c:if test="${popupVO.searchType eq 'content'}">selected</c:if>>내용</option>
							</select>
						</div>
						<input type="text" name="searchKeyword" class="form-control" value="${popupVO.searchKeyword}">
						<span class="input-group-btn">
							<button type="submit" class="btn btn-primary">검색
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</span>
					</div>
				
				</div>
			</div>
			</form>
			
			<div class="row">
				<div class="col-sm-12">

					<div class="table-responsive">
						<table class="table table-bordered table-hover text-center">
							<thead>
								<tr>
									<th width="30">No.</th>
									<th width="180">Title</th> 	
									<th width="50">Contents</th>
									
								</tr>
							</thead>
							<tbody>
								<c:set var="rownum" value="${pageVO.rownum }"/>
								<c:forEach var="item" items="${list }">
								<tr>
									<td>${rownum }</td>
									<td class="text-left"><a onclick="view(${item.popupNo})">${item.title }</a></td>
									<td><fmt:formatDate value="${item.insertDate }" pattern="yyyy-MM-dd"/> </td>
									
								</tr>
								<c:set var="rownum" value="${rownum-1 }"/>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<jsp:include page="/WEB-INF/jsp/layout/common/paging-admin.jsp"/>
					
				</div>
			</div>
			
       
		</div>
	</div>
</div>

<script>
$("#group_sel").change(function(){

	var params = $('#exposureForm').serialize();
	$.ajax({
		url:"/admin/popup/popupList/"+popupNo,
		type:'post',
		data:params,
		success:function(response){
			if(response.msg);
			fnReload(); 
		}
	});
});
$(function(){
	activeMenu('/admin/popup/popupList');
});



function view(popupNo){
	location.href= popupNo+'?'+window.location.search.substring(1);
}

function del(popupNo){
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params={
			popupNo: popupNo
	}
	
	$.ajax({
		url : "./delete",
		type: 'post',
		data: params,
		dataType: 'json',
		success:function(response){
			alert(response.msg);
			if(response.result){
				fnReload();
				
			}
		}
	});
}
</script>