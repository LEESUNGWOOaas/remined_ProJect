<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="header"> 
	<h1 class="page-header">
		<small>Board</small>
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
					<td>${boardVO.title }</td>
				</tr>
				
				<tr>
					<th>InsertDate</th>
					<td>${boardVO.insertDate}</td>
				</tr>
				
				
				<tr>
					<th>Contents</th>
					<td style=" line-height: 1.5em">${boardVO.content }</td>
				</tr>
				
				
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="수정" onclick="goForm(${boardVO.boardNo})"> 
                       <input type="button" class="btn btn-danger" value="삭제" onclick="del(${boardVO.boardNo})"> 
                       <input type="button" class="btn btn-default" value="목록으로" onclick="goList();"> 
				</div>
			</div>
				
		</div>
	</div>
</div>


<script>
$(function(){
	activeMenu('/admin/board/boardList');
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("/admin/board/boardList");
}


function goForm(boardNo){
	location.href='./boardForm?boardNo='+boardNo+'&'+window.location.search.substring(1);
}

function del(boardNo) {
	
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params = {
		"boardNo": boardNo
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


