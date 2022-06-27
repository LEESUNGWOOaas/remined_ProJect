<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

    
<div class="header"> 
	<h1 class="page-header">
		 <small>Board</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="row mb-10 ">
		<div class="col-sm-12 text-right">

			 <a href="introduceForm" class="btn btn-sm btn-primary">등록</a><br/>
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
								<option value="title" <c:if test="${introduceNo.searchType eq 'title'}">selected</c:if>>제목</option>
								<option value="content" <c:if test="${introduceNo.searchType eq 'content'}">selected</c:if>>내용</option>
							</select>
						</div>
						<input type="text" name="searchKeyword" class="form-control" value="${introduceNo.searchKeyword}">
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
									<th width="180">Project Title</th> 	
									<th width="50">User</th>
									<th width="50">Release Date</th>
								</tr>
							</thead>
							
							<tbody>
								<c:set var="rownum" value="${pageVO.rownum }"/>
								<c:forEach var="item" items="${list }">
								<tr>
									<td>${rownum }</td>
									<td class="text-left"><a onclick="view(${item.introduceNo})">${item.title }</a></td>
									<td>${item.introduceUser }</td>
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
		url:"/admin/introduce/introduceList/"+introduceNo,
		type:'post',
		data:params,
		success:function(response){
			if(response.msg);
			fnReload(); 
		}
	});
});
$(function(){
	activeMenu('/admin/introduce/introduceList');
});



function view(introduceNo){
	location.href= introduceNo+'?'+window.location.search.substring(1);
}

function del(introduceNo){
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params={
			introduceNo: introduceNo
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