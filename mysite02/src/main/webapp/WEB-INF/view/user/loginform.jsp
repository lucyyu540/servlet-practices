<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/view/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="/mysite02/user/login">
					<label class="block-label" for="email">이메일</label> 
					<input id="email" name="email" type="text" value=""> 
					<label class="block-label">비밀번호</label> 
					<input name="password"type="password" value="">
					<p>${message}</p>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/view/includes/navigation.jsp" />
		<c:import url="/WEB-INF/view/includes/footer.jsp" />

	</div>
</body>
</html>