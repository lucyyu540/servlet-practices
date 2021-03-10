<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.List" 
	import="com.lucy.guestbook.dao.Dao" 
	import="com.lucy.guestbook.model.GuestVo" 
	import="java.util.ArrayList" %>
	
<%--LOAD GUEST LIST FROM DB--%>
<%
Dao dao = new Dao();
List<GuestVo> guests = dao.selectAll();
if(guests == null) guests = new ArrayList<GuestVo>();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest Book Main</title>
</head>
<body>
	<%--ADDING NEW GUEST --%>
	<form action="/guest-book/add" method='post'>
		<table border="1">
			<tr>
				<td>이름 :</td>
				<td><input type='text' name='name' value='' /></td>
				<td>비밀번호 :</td>
				<td><input type='password' name='password' value='' /></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="etc"
						style="width: 100%; max-width: 100%;"></textarea></td>
			</tr>
			<tr>
				<td><input type='submit' value='확인' /></td>
			</tr>

		</table>
	</form>
	<br />
	<br />
	<%--SHOWING REGISTERED GUEST FROM DB--%>
	
		<table border="1" style="width: 50%">
			<% for(GuestVo g : guests) { %>
				<tr>
					<td width="5%"><%=g.getIdguestbook() %></td>
					<td><%=g.getName() %></td> <%--name --%>
					<td><%=g.getDate() %></td> <%-- date--%>
					<td> <a href="deleteform.jsp?id=<%=g.getIdguestbook()%>">삭제</a></td>										
				</tr>
				<tr>
					<td colspan="4"><%=g.getText() %></td> <%--text--%>
				</tr>
			<% } %>
		</table>
</body>
</html>