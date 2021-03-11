<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      import="com.lucy.guestbook01.dao.Dao"
    import="com.lucy.guestbook01.model.GuestVo"
    %>
<%
int id = Integer.parseInt(request.getParameter("id"));
String pw = request.getParameter("password");
new Dao().delete(id, pw);

response.sendRedirect("/guestbook01");


%>