<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.lucy.guestbook01.dao.Dao"
    import="com.lucy.guestbook01.model.GuestVo"
    import="java.util.List"
    %>
<%
List<GuestVo> guests = new Dao().selectAll();

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%for (GuestVo g : guests ) { %>
	<table width=510 border=1>
		<tr>
			<td><%= g.getIdguestbook() %></td>
			<td><%= g.getName() %></td>
			<td><%= g.getDate() %></td>
			<td><a href="deleteform.jsp?id=<%= g.getIdguestbook() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%= g.getText() %></td>
		</tr>
	</table>
	<%} %>
</body>
</html>