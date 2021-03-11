package com.lucy.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.guestbook.dao.Dao;
import com.lucy.guestbook.model.GuestVo;
import com.lucy.web.mvc.WebUtil;
/**
 * Servlet implementation class GuestBookServlet
 */
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void displayIndex(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		List<GuestVo> l = new Dao().selectAll();
		request.setAttribute("guests", l);
		//forwarding (request dispatch = req extension)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length-1];
		if(action.equals("form")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deleteform.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("add")) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String etc = request.getParameter("etc");
			//name and password must not be null
			if(name!= null && password != null) new Dao().create(new GuestVo(name, password, etc));
			displayIndex(request, response);
		}
		else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			new Dao().delete(id, password);
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
