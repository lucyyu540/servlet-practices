
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String no = request.getParameter("no");
	
	int number = -11;
	if( no != null && no.matches("\\d*")){
		number = Integer.parseInt(no);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<%
		for (int i  = 0; i < 3; i ++) {
	%>
	<h1>Hello world from index.jsp</h1>
	<%
		}
	%>
	<a href="tag.jsp">tag.jsp link</a>
	<br/>
	<a href="tag.jsp" target='_blank'>tag.jsp link in a new tab</a>
	<br/>
	<a href="form.jsp">form.jsp link</a>
	<br/>
	
	<h2>number in url</h2>
	<p>
		<%=number+10 %>
	</p>
</body>
</html>