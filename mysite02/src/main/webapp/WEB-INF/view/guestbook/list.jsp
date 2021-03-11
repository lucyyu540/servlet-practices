<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.lucy.mysite02.model.GuestVo" import="java.util.List"%>
    <%
    List<GuestVo> guests = (List<GuestVo>) request.getAttribute("guests");
    %>
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

		<div id="content">
			<div id="guestbook">
				<form action="/mysite02/guestbook/add" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
				<% for(GuestVo g : guests) {%>
					<li>					
						<table>
							<tr>
								<td>[<%= g.getNo() %>]</td>
								<td><%= g.getName() %></td>
								<td><%= g.getReg_date() %></td>
								<td><a href="/mysite02/guestbook/deleteform?no=<%=g.getNo()%>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4><%= g.getContents() %><br></td>
							</tr>
						</table> <br>
					</li>
					<%} %>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/view/includes/footer.jsp" />
	</div>
</body>
</html>