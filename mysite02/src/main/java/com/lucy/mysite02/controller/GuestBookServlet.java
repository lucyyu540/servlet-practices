package com.lucy.mysite02.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.mysite02.dao.GuestBookDao;
import com.lucy.mysite02.model.GuestVo;

//response.sendRedirect(request.getContextPath());
//request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length-1];
		
		if(action.equals("deleteform")) {//guestbook/deleteform
			request.getRequestDispatcher("/WEB-INF/view/guestbook/deleteform.jsp").forward(request, response);;
		}
		else if(action.equals("delete")) {//guestbook/delete
			//read from request
			int id = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("password");
			System.out.println(id + " " + pw);
			//deleteing from db
			new GuestBookDao().delete(id, pw);
			//redirect
			response.sendRedirect(request.getContextPath()+"/guestbook");

		}
		else if(action.equals("add")) {//guestbook/add
			//reading data from requestion
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("content");
			//saving to db
			new GuestBookDao().create(new GuestVo(name, password, contents));
			//redirect
			response.sendRedirect(request.getContextPath()+"/guestbook");
		}
		else {// /guestbook
			List<GuestVo> l = new GuestBookDao().selectAll();
			request.setAttribute("guests", l);
			//forward
			request.getRequestDispatcher("/WEB-INF/view/guestbook/list.jsp").forward(request, response);;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
