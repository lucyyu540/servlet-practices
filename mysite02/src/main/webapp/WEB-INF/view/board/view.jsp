<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/view/includes/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<c:if test="${board.depth == 1}">
						<tr>
							<td class="label">제목</td>
							<td>${board.title}</td>
						</tr>
					</c:if>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${board.content}
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
				
					<a href="/mysite02/board">글목록</a>
					<c:if test="${user.no == board.authorNo }">
						<a href="/mysite02/board/modifyform?no=${board.no}">글수정</a>
					</c:if>
					<c:if test="${user != null}">
						<a href="/mysite02/board/addform?g_no=${board.g_no}&o_no=${board.o_no}&depth=${board.depth+1}">답글</a>
					</c:if>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>