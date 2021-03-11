<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.lucy.guestbook01.dao.Dao"
    import="com.lucy.guestbook01.model.GuestVo"
    %>
<%
String name = request.getParameter("name");
String password = request.getParameter("password");
String message = request.getParameter("message");

new Dao().create(new GuestVo(name, password, message));

response.sendRedirect("/guestbook01");
%>