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
			<div id="user">
				<p class="jr-success">
					회원가입을 축하합니다. <br>
					<br> <a href="/user/loginform">로그인하기</a>
				</p>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />

		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />

	</div>
</body>
</html>