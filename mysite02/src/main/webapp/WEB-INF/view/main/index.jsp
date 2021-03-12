<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.lucy.mysite02.model.UserVo"
	%>
	<%UserVo user = (UserVo) request.getSession().getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/view/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="<%=request.getContextPath()%>/assets/images/profile.jpg">
					<%if(user!= null) { %>
					<h2>
						안녕하세요.
						${user.name}의 mysite에 오신 것을
						환영합니다.
					</h2>
					<%} %>
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						Python 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트
						입니다.<br> <br> <a href="guestbook">방명록</a>에 글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>