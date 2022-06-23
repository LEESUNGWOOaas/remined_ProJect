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

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"></div>
			</div>
		</div>
		<div class="panel-body">
		<input type="hidden" name="boardNo" value="${empty boardVO? 0:boardVO.boardNo }">
			<form id="regForm" class="form-horizontal" >
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>

					
					<tr>
						<th>*Title</th>
						<td><input type="text" name="title" id="title" title="title" class="form-control" value="${boardVO.title }"required></td>
					</tr>
					
					<tr>
						<th>*Contents</th>
						<td ><textarea name="content" id="content" title="content" class="form-control"  required>${boardVO.content }</textarea></td>
					</tr>
					
						
					
				</table>
				
				
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button type="button" class="btn btn-default" onclick="cancel();">취소</button>
						<button type="button" class="btn btn-primary" onclick="save();">저장</button>
					</div>
				</div>
				
			</form>
		</div>
	</div>

</div>
<script>
$(function(){
	activeMenu('/admin/board/boardList');
	CKEDITOR.replace("content");
	
});

function goList() {
		var params = fnGetPrevParmas("");
		fnRedirect("/admin/board/boardList");
}
		

function cancel(){
			var url = "${empty boardVO? 'list':boardVO.boardNo}";
			var params = fnGetPrevParmas("boardNo");
			fnRedirect(url+'?'+params);
		}		
		

function save(){
	$('#content').val(CKEDITOR.instances.content.getData());
			
			var userId = $('#title').val();
			var userName = $('#content').val();
			
			
			
			if(title == ""){
				alert("제목을 입력해주세요");
			}
			if(content == ""){
				alert("내용을 입력해주세요")
			}
			
		
			
		/* 	파일이 존재시 사용함
			var form = $('#regForm')[0];a
			var formData = new FormData(form);
			
			$.ajax({
			    url : "/admin/board/save",
				type: 'POST',
				data: formData,
				enctype: 'multipart/form-data',
		        processData: false,
		        contentType: false,		
				success: function(response) {
					console.log(response);
					alert(response.msg);
					if(response.result){
					goList();		
				}
			}
		}); */
		var param = $('#regForm').serialize();
		
			$.ajax({
			    url : "/admin/board/save",
				type: 'POST',
				data: param,
				dataType: 'json',
				success: function(response) {
					console.log(response);
					alert(response.msg);
					if(response.result){
						goList();
					}
				}
			});
}
</script>