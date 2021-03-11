<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="com.lucy.emaillist01.dao.Dao" 
    import="com.lucy.emaillist01.model.EmailListVo"
    %>
<%
//request.setCharacterEncoding("utf-8");

String fn = request.getParameter("fn");
String ln = request.getParameter("ln");
String email = request.getParameter("email");

new Dao().create(new EmailListVo(fn,ln,email));

response.sendRedirect("/emaillist01");
%>