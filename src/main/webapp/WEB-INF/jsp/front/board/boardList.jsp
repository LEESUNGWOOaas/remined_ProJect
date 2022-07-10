<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<style>
	.bg-light{
		bottom : 0;
	}
</style>
<jsp:include page="/WEB-INF/jsp/layout/front/other/nav.jsp" />
<div class="masthead">
	<img alt="top" src="/assets/front/assets/img/bg-masthead22.jpg">

	<c:set var="rownum" value="${pageVO.rownum }" />
	<c:forEach var="item" items="${list }">
		<div class="card m-2">
			<div>${rownum }</div>
			<!-- 글 번호 	-->
			<div style="margin: 3px;" class="card-body">
				<h4 class="card-title">${item.title }</h4>
				<p class="card-text">Writer : ${item.userId }</p>
				<a href="/front/board/${item.boardNo }" class="btn btn-primary">View</a>
			</div>
			<br/>
			<c:set var="rownum" value="${rownum-1 }" />
		</div>
	</c:forEach>

</div>
		<jsp:include page="/WEB-INF/jsp/layout/common/paging-admin.jsp"/>

<jsp:include page="/WEB-INF/jsp/layout/front/other/footer.jsp"/>

