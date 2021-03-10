package com.lucy.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.guestbook.model.GuestVo;
import com.lucy.guestbook.dao.Dao;
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("ADD SERVLET DO POST");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String etc = request.getParameter("etc");
		
		dao.create(new GuestVo(name, password, etc));
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
