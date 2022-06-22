<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<div class="header"> 
	<h1 class="page-header">
		 <small>User</small>
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
		<input type="hidden" name="userNo" value="${empty userVO? 0:userVO.userNo }">
			<form id="regForm" class="form-horizontal" >
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>

					<%-- <tr>
						<th>공개범위</th>
						<td>
						<select name="useYn">
						<option value="요약 공개" <c:if test="${userVO.useYn eq '요약 공개'}">selected</c:if>>요약 공개</option>
						<option value="전체 공개" <c:if test="${userVO.useYn eq '전체 공개'}">selected</c:if>>전체 공개</option>
						</select>
						<input type="hidden" name="공개범위" id="useYn" title="공개범위" class="form-control" value="${userVO.useYn }" required></td>
					</tr> --%>
					
					<tr>
						<th>*Name</th>
						<td><input type="text" name="userName" id="userName" title="userName" class="form-control" value="${userVO.userName }"required></td>
					</tr>
					
					<tr>
						<th>*NickName</th>
						<td ><input type="text" name="userId" id="userId" title="userId" class="form-control"  required>${userVO.userId }</td>
					</tr>
					
					<tr>
						<th>Email</th>
						<td ><input type="text" name="email" id="email" title="email" class="form-control"  required>${userVO.email }</td>
					</tr>
					
					<tr>
						<th>*PassWord</th>
						<td ><input type="text" name="pwd" id="pwd" title="pwd" class="form-control"  required>${userVO.pwd }</td>
					</tr>
					
					<tr>
						<th>Gender</th>
					<td><input type="radio" class="sci" name="gender" id="Male" title="범위" value="M"${userVO.gender eq 'M'? 'checked':empty userVO? 'checked':'' } ><label for="domestic">남성</label>
					   	<input type="radio" class="sci" name="gender" id="Female" title="범위" value="F"${userVO.gender eq 'F'? 'checked':'' } ><label for="abroad">여성</label></td>
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
	activeMenu('/admin/user/userList');
});

function goList() {
		var params = fnGetPrevParmas("");
		fnRedirect("/admin/user/userList");
}
		

function cancel(){
			var url = "${empty userVO? 'list':userVO.userNo}";
			var params = fnGetPrevParmas("userNo");
			fnRedirect(url+'?'+params);
		}		
		

function save(){

			//return;
			var userId = $('#userId').val();
			var userName = $('#userName').val();
			var gender = $('#gender').val();
			var pwd = $('#pwd').val();
			var email = $('#email').val();
			
			
			if(userId == ""){
				alert("닉네임을 입력해주세요");
			}
			if(userName == ""){
				alert("이름을 입력해주세요")
			}
			
			if(pwd==''){
				alert("비밀번호를 입력해주세요");
			}
			
		/* 	파일이 존재시 사용함
			var form = $('#regForm')[0];a
			var formData = new FormData(form);
			
			$.ajax({
			    url : "/admin/bbs/bbs001/save",
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
			    url : "/admin/user/save",
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