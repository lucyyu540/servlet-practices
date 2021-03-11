package com.lucy.mysite02.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.mysite02.dao.UserDao;
import com.lucy.mysite02.model.UserVo;


//response.sendRedirect(request.getContextPath());
//request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);;
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length-1];
		if(action.equals("joinform")) {
			request.getRequestDispatcher("/WEB-INF/view/user/joinform.jsp").forward(request, response);;
		}
		else if(action.equals("join")) {
			//retrieve data from request
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			//save to db
			new UserDao().create(new UserVo(name, email, password, gender));
			//redirect
			response.sendRedirect(request.getContextPath());
			request.getRequestDispatcher("/WEB-INF/view/main/index.jsp").forward(request, response);;
		}
		else if(action.equals("loginform")) {
			request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);;
		}
		else if(action.equals("login")) {
			
			request.getSession().setAttribute("user", null);
			request.getRequestDispatcher("/WEB-INF/view/main/index.jsp").forward(request, response);;
		}
		else if(action.equals("updateform")) {
			request.getRequestDispatcher("/WEB-INF/view/user/joinform.jsp").forward(request, response);;
		}
		else if(action.equals("logout")) {
			response.sendRedirect(request.getContextPath());
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
