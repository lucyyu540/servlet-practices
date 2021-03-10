package com.lucy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");//kor character setting;
		PrintWriter pw = response.getWriter();
		pw.print("ok");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ADD SERVLET DO POST");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String etc = request.getParameter("etc");
		String date= new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()).toString();
		ArrayList<String[]> list = (ArrayList<String[] >) request.getSession().getAttribute("guests");
		String[] res = {name, password, etc, date};
		list.add(res);
		request.setAttribute("guests", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
				
	}

}
