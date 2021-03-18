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
				<form id="search_form" action="/mysite02/board/search" method="post">
					<input type="text" id="kwd" name="msg" value="">
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
						<c:choose>
							<c:when test="${ null== param.p || param.p == 1}" >
								<li><a href="/mysite02/board?p=1">◀</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/mysite02/board?p=${param.p-1 }">◀</a></li>
							</c:otherwise>
						</c:choose>		
						<c:forEach begin="1" end="${pagesCount}" varStatus="loop">
							<c:choose>
								<c:when test="${ null== param.p && loop.index == 1}" >
									<li class="selected"><a href="/mysite02/board?p=1">1</a></li>
								</c:when>
								<c:when test="${ param.p == loop.index}" >
									<li class="selected"><a href="/mysite02/board?p=${loop.index}">${loop.index}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/mysite02/board?p=${loop.index}">${loop.index}</a></li>
								</c:otherwise>
							</c:choose>						
						</c:forEach>
						<c:choose>
							<c:when test="${ null== param.p && 1 < pagesCount}" >
								<li><a href="/mysite02/board?p=${2}">▶</a></li>
							</c:when>
							<c:when test="${ param.p < pagesCount}" >
								<li><a href="/mysite02/board?p=${param.p+1 }">▶</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/mysite02/board?p=${param.p}">▶</a></li>
							</c:otherwise>
						</c:choose>		
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