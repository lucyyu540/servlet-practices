<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.lucy.mysite02.model.UserVo"
	%>
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
		<c:import url="/WEB-INF/view/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="${pageContext.servletContext.contextPath}/assets/images/profile.jpg">
					<c:if test="${user !=null }">
						<h2>
							안녕하세요.
							${user.name}의 mysite에 오신 것을
							환영합니다.
						</h2>
					</c:if>
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						<br> <br> 
						<a href="guestbook">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/view/includes/navigation.jsp" />
		<c:import url="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>