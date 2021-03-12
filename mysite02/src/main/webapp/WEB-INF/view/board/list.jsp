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
<link href="${pageContext.servletContext.contextPath}/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/view/includes/header.jsp" />

		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items='${boards}' var='b' varStatus='status'>
						<tr>
							<td>${status.index+1}</td>
							<td><a href="/mysite02/board/view?${b.no}">${b.title}</a></td>
							<td>${b.author}</td>
							<td>3{b.count}</td>
							<td>${b.reg_date}</td>
							<c:if test="${user.no == b.authorNo }">
								<td><a href="/mysite02/board/delete" class="del">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>				
				</table>
				<div class="bottom">
					<a href="/mysite02/board/addform" id="new-book">글쓰기</a>
				</div>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>