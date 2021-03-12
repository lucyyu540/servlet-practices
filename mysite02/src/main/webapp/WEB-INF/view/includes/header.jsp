<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.lucy.mysite02.model.UserVo"
    %>
    <%UserVo user = (UserVo)session.getAttribute("user");%>
		<div id="header">
			<h1>MySite</h1>
			<ul><%if (user==null ) { %>
				<li><a href="<%=request.getContextPath()%>/user/loginform">로그인</a><li>
				<li><a href="<%=request.getContextPath()%>/user/joinform">회원가입</a><li>
				<%} 
				else { %>
				<li><a href="<%=request.getContextPath()%>/user/updateform">회원정보수정</a><li>
				<li><a href="<%=request.getContextPath()%>/user/logout">로그아웃</a><li>
				<li> <%=user.getName()%>님 안녕하세요</li>
				<%} %>
			</ul>
		</div>