package com.lucy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.dao.Dao;
import com.lucy.model.EmailListVo;


public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void displayIndex(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		List<EmailListVo> l = new Dao().selectAll();
		request.setAttribute("emails", l);
		//forwarding (request dispatch = req extension)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length-1];
		if(action.equals("form")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/form.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("add")) {
			String firstname = request.getParameter("fn");
			String lastname = request.getParameter("ln");
			String email = request.getParameter("email");
			if(firstname != null && lastname != null && email != null) new Dao().create(new EmailListVo(firstname, lastname, email));
			displayIndex(request, response);
		}
		else {//default --> index.jsp
			displayIndex(request,response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
