package com.lucy.guestbook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.guestbook.dao.Dao;
import com.lucy.guestbook.model.GuestVo;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id + " " + password);
		//check password then delete
		dao.delete(id, password); 
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
