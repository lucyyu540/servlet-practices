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
							<td >${b.no}</td>
							<td style="text-align:left; padding-left:${(b.depth-1)*20}px">
							<a href="/mysite02/board/view?no=${b.no}">${b.title}</a>
							<c:if test="${b.title==null }">
								<img src="${pageContext.request.contextPath }/assets/images/reply.png" />
								<a href="/mysite02/board/view?no=${b.no}">${b.content}</a>
							</c:if>
							</td>
							
							<td>${b.author}</td>
							<td>${b.count}</td>
							<td>${b.reg_date}</td>
							<c:if test="${user.no == b.authorNo }">
								<td><a href="/mysite02/board/delete?no=${b.no}" class="del">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>				
				</table>
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li class="selected"><a href="/mysite02/board?p=1">1</a></li>
						<li><a href="/mysite02/board?p=2">3</a></li>
						<li><a href="/mysite02/board?p=3">4</a></li>
						<li>5</li>
						<li>6</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>					
				<!-- pager 추가 -->	
				<div class="bottom">
					<c:if test="${user != null}">
						<a href="/mysite02/board/addform" id="new-book">글쓰기</a>
					</c:if>
				</div>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>