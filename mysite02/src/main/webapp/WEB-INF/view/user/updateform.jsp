<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.lucy.mysite02.model.UserVo"%>
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

				<form id="join-form" name="joinForm" method="post"
					action="mysite02/user/update">
					<h4>${uservo.email}</h4>
					<label class="block-label" for="name">이름</label> 
					<input id="name"name="name" type="text" value=""> 
					<label class="block-label">패스워드</label> 
					<input name="password" type="password" value="">
					<fieldset>
						<legend>성별</legend>
						<c:choose>
							<c:when test="${uservo.gender == 'female'}">
								<label>여</label> 
								<input type="radio" name="gender" value="female" checked="checked"> 
								<label>남</label> 
								<input type="radio" name="gender" value="male">
							</c:when>
							<c:otherwise>
								<label>여</label> 
								<input type="radio" name="gender" value="female"> 
								<label>남</label> 
								<input type="radio" name="gender" value="male"  checked="checked">
							</c:otherwise>
						</c:choose>						
					</fieldset>
					<input type="submit" value="저장">

				</form>
			</div>
		</div>
			<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
			<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>