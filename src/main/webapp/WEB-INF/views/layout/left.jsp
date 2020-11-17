<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-sidebar">
	<li class="active"><a href="${pageContext.request.contextPath }/board/boardList">게시판관리</a></li>
	<c:forEach var="board" items="${boardList }">
		<c:if test="${board.board_status == 'Y' }">
			<li class="active">
				<a href="${cp }/post/postList?board_no=${board.board_no }">${board.board_title }</a>
			</li>
		</c:if>
	</c:forEach>
	<%
		pageContext.getRequest();
	%>
</ul>