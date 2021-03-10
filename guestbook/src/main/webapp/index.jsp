<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>

<%
	//ArrayList<String[]> guests = new ArrayList<String[]>();
	ArrayList<String[]> guests = (ArrayList<String[]>)session.getAttribute("guests");
	if(guests == null) {
		guests = new ArrayList<String[]>();
		session.setAttribute("guests", guests);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Book Main</title>
</head>
<body>
	<form action="/guestbook/add" method='post'>
		<table border="1" >
			<tr>
				<td>이름 : </td>
				<td><input type='text' name='name' value='' /></td>
				<td>비밀번호 :</td>
				<td> <input type='password' name='password' value='' /></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="etc" style="width: 100%; max-width: 100%;"></textarea></td>
			</tr>
			<tr>
				<td><input type='submit' value='확인' /></td>
			</tr>

		</table>
	</form>
	<br/><br/>
	<table border="1"  style="width: 50%">
	<% if (guests!= null) for (int i = 0 ; i < guests.size() ; i ++) { %>
		<tr>
			<td width="5%"><%=i+1%></td>
			<td><%=guests.get(i)[0]%></td><%--name --%>
			<td><%=guests.get(i)[3]%></td><%-- date--%>
			<td><input type='submit' value='삭제' /></td>
		</tr>
		<tr>
			<td colspan="4"><%=guests.get(i)[2]%></td><%--text--%>
		</tr>
	</table>
	<% } %>	


</body>
</html>