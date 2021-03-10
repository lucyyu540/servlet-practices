package com.lucy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthYear = request.getParameter("birthYear");
		String[] hobbies = request.getParameterValues("hobbies");
		String gender = request.getParameter("gender");
		String intro = request.getParameter("intro");
		
		System.out.println(email);
		System.out.println(password);
		System.out.println(birthYear);
		System.out.println(gender);
		if( hobbies != null ) for(String hobby : hobbies) System.out.println(hobby);
		System.out.println(intro);
		
		response.setContentType("text/html; charset=utf-8");//kor character setting;
		PrintWriter pw = response.getWriter();
		pw.print("ok");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
