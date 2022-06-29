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

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"></div>
			</div>
		</div>
		<div class="panel-body">
			<form id="regForm" class="form-horizontal" >
				<input type="hidden" name="popupNo" value="${empty popupVO? 0:popupVO.popupNo }">
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>

					
					<tr>
						<th>*Title</th>
						<td><input type="text" name="title" id="title" title="title" class="form-control" value="${popupVO.title }"required></td>
					</tr>
					<tr>
						<th>*Contents Type</th>
						<td>
							<div class="radio radio-inline radio-check radio-info">
								<input type="radio" name="contentType" id="editor" title="editor" class="contentType" value="editor"${popupVO.contentType eq editor ? 'checked':empty popupVO? 'checked':'' } required>
								<label for="editor">Editor</label>
								</div>
							<div class="radio radio-inline radio-check radio-info">
								<input type="radio" name="contentType" id="image" title="image" class="contentType" value="image"${popupVO.contentType eq 'image'? 'checked':'' }  required>
								<label for="image">Image</label>
							</div>
						</td>
					</tr>
					<tr>
						<th>View Size</th>						
						<td>Width&nbsp;&nbsp;<input type="text"  name="width" id="width" style="width:40%; display:inline-block;" title="width" class="form-control" value="${popupVO.width}">&nbsp;
					&nbsp;Height&nbsp;&nbsp;<input type="text" name="height" id="height" title="height" style="width:40%; display:inline-block;" class="form-control" value="${popupVO.height }"></td>
					</tr>
					<tr>
						<th>View Location</th>
						<td>X&nbsp;<input type="text" name="lotationX" id="lotationX" style="width:20%; display:inline-block;" title="lotationX" class="form-control" value="">&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;Y&nbsp;<input type="text" name="lotationY" id="lotationY" style="width:20%; display:inline-block;" title="lotationY" class="form-control" value=""></td>
					</tr>
					<tr class="contentType-editor" ${empty popupVO ||popupVO.contentType eq 'image'? 'hide':'' }>
						<th>*Contents</th>
						<td ><textarea name="content" id="content" title="content" class="form-control"  required>${popupVO.content }</textarea></td>
					</tr>
					<tr class="contentType-image" ${empty popupVO ||popupVO.contentType eq 'editor'? 'hide':'' }>
						<th>File</th>
						<td><input type="file" name="File" id="File" title="File" class="form-control"></td>
					<tr>
						<th scope="row">Popup ExposureTime</th>
						<td>
							<label for="">
								<input type="text" name="startDate" id="datepicker_str" class="form-control-range datepicker" value="${popupVO.startDate }" title="시작일" required>
								~
								<input type="text" name="endDate" id="datepicker_end" class="form-control-range datepicker" value="${popupVO.endDate }" title="종료일" required>
							</label>
						</td>
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
	activeMenu('/admin/popup/popupList');
	CKEDITOR.replace("content");
	
	
	$(".contentType").change(function(){
		var contentType = $(this).val();
		if(contentType=='editor'){
			$(".contentType-content").removeClass("hide");//selectType-content클래스의 hide기능 제거
			$(".contentType-image").addClass("hide");//selectType-image클래스의 hide기능 추가
		}else if(contentType=='image'){
			$(".contentType-image").removeClass("hide");
			$(".contentType-content").addClass("hide");
		} 
	});
	
});

function goList() {
		var params = fnGetPrevParmas("");
		fnRedirect("/admin/popup/popupList");
}
		

function cancel(){
			var url = "${empty popupVO? 'List':popupVO.popupNo}";
			var params = fnGetPrevParmas("popupNo");
			fnRedirect(url+'?'+params);
		}		
		

function save(){
	$('#content').val(CKEDITOR.instances.content.getData());
			
			var userId = $('#title').val();
			var userName = $('#content').val();
			
			
			
			if(title == ""){
				alert("제목을 입력해주세요");
				return;
			}
			if(content == ""){
				alert("내용을 입력해주세요")
				return;
			}
			
		
		
			
			var form = $('#regForm')[0];
			var formData = new FormData(form);
			
			$.ajax({
			    url : "/admin/popup/save",
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
		}); 
		/* var param = $('#regForm').serialize();
		
			$.ajax({
			    url : "/admin/popup/save",
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
			}); */
}
</script>