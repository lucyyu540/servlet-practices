<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="com.lucy.guestbook01.dao.Dao"
    import="com.lucy.guestbook01.model.GuestVo"
    %>
    <%
    int id = Integer.parseInt(request.getParameter("id"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="delete.jsp?id=<%=id%>">
	<input type='hidden' name="id" value="">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook01">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>>
</html>