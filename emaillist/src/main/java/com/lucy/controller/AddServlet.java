package com.lucy.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.dao.Dao;
import com.lucy.model.EmailListVo;
/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = new Dao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		String email = request.getParameter("email");
		dao.create(new EmailListVo(firstname, lastname, email));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
