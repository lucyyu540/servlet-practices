<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.lucy.mysite02.model.UserVo"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="navigation">
			<ul>
				<c:if test="${user != null }">
					<li><a href="/mysite02/user">${user.name}</a></li>
				</c:if>
				<li><a href="/mysite02/guestbook">방명록</a></li>
				<li><a href="/mysite02/board">게시판</a></li>
			</ul>
		</div>