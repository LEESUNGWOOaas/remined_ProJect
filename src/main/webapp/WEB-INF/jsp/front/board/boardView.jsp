<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="masthead">
	<img alt="top" src="/assets/front/assets/img/bg-masthead22.jpg">
		<div class="container">
			<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<br /> <br />
	<div>
		글 번호 :<span id="id"><i>${boardVO.boardNo} </i></span> 작성자 :<span><i>${board.user.username} </i></span>
	</div>
	<br />
	<div class="form-group">
		<label for="title">Title</label>
		<h3>${boardVO.title }</h3>
	</div>
	
	<div class="card">
	<form>
		<%-- <input type="hidden" id="userId" value="${boardVO.userId}"/> --%>
		<input type="hidden" id="boardId" value="${boardVO.boardNo }"/>
		<div class="card-body">
			<textarea id="reply-content" class="form-control" rows="1"></textarea>
		</div>
		<div class="card-footer">
			<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
		</div>
		</form>
	</div>
	<br />
	
	<div class="card">
		<div class="card-header">댓글 리스트</div>
			<ul id="reply-box" class="list-group">
				<c:forEach var="reply" items="${boardVO.reply}">
					<li id="reply-${reply.replyNo }" class="list-group-item d-flex justify-content-between">
						<div>${reply.content}</div>
						<div class="d-flex">
							<div class="font-italic">작성자 : ${reply.userName} &nbsp;</div>
							<button onClick="index.replyDelete(${boardNo.boardNo},${reply.replyNo})" class="badge">삭제</button>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	
		</div>
</div>
<jsp:include page="/WEB-INF/jsp/layout/common/paging-front.jsp"/>


<jsp:include page="/WEB-INF/jsp/layout/front/footer.jsp"/>