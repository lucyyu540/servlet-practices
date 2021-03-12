<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.lucy.mysite02.model.UserVo"
    %>
    <% UserVo user = (UserVo)session.getAttribute("user");%>
<div id="navigation">
			<ul>
			<% if (user != null) { %>
				<li><a href="/mysite02/user"><%=user.getName() %></a></li>
			<%} %>
				<li><a href="/mysite02/guestbook">방명록</a></li>
				<li><a href="/mysite02/board">게시판</a></li>
			</ul>
		</div>