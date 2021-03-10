<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="com.lucy.model.EmailListVo" import="com.lucy.dao.Dao"%>
<%
Dao dao = new Dao();
List<EmailListVo> emails = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일 리스트</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%for(EmailListVo e : emails) { %>
	
	<table border="1" cellpadding="5" cellspacing="2">
			<tr>
				<td align=right>First name: </td>
				<td><%= e.getFirstname() %></td>
			</tr>
			<tr>
				<td align=right width="110">Last name: </td>
				<td width="110"><%= e.getLastname() %></td>
			</tr>
			<tr>
				<td align=right>Email address: </td>
				<td><%= e.getEmail() %></td>
			</tr>
	</table>
	<%} %>
	<br>
	<p>
		<a href = "/emaillist/form.jsp">추가메일 등록</a>
	</p>
	<br>
</body>
</html>
