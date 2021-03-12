package com.lucy.mysite02.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lucy.mysite02.dao.UserDao;
import com.lucy.mysite02.model.UserVo;

//response.sendRedirect(request.getContextPath());
//request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);;
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//URI
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length - 1];
		
		if (action.equals("joinform")) {
			request.getRequestDispatcher("/WEB-INF/view/user/joinform.jsp").forward(request, response);
		} 
		else if (action.equals("join")) {
			// retrieve data from request
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			// save to db
			new UserDao().create(new UserVo(name, email, password, gender));
			// redirect
			response.sendRedirect(request.getContextPath() + "/user/joinsuccess");
		} 
		else if (action.equals("joinsuccess")) {
			request.getRequestDispatcher("/WEB-INF/view/user/joinsuccess.jsp").forward(request, response);
			
		}
		else if (action.equals("loginform")) {
			request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);
			
		} 
		else if (action.equals("login")) {
			String email = request.getParameter("email");
			String pw = request.getParameter("password");
			UserVo u = new UserDao().select(email, pw);
			// log in fail
			if (u == null) {
				request.setAttribute("message", "로그인이 실패 했습니다.");
				request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);
				return;
			}
			// log in success
			request.getSession().setAttribute("user", u);
			response.sendRedirect(request.getContextPath());

		} 
		else if (action.equals("updateform")) {
			//access control
			HttpSession session = request.getSession();
			if(session != null && session.getAttribute("user")!= null) {
				UserVo user = (UserVo) session.getAttribute("user");
				UserVo uservo = new UserDao().findByNo(user.getNo());
				request.setAttribute("uservo", uservo);
				request.getRequestDispatcher("/WEB-INF/view/user/updateform.jsp").forward(request, response);

			}
			else response.sendRedirect(request.getContextPath());
		} 
		else if (action.equals("update")) {
			//access control
			HttpSession session = request.getSession();
			if(session != null && session.getAttribute("user")!= null) {
				UserVo user = (UserVo) session.getAttribute("user");
				UserVo uservo = new UserDao().findByNo(user.getNo());
				request.setAttribute("uservo", uservo);
				request.getRequestDispatcher("/WEB-INF/view/user/updateform.jsp").forward(request, response);

			}
			else response.sendRedirect(request.getContextPath());
		} 
		else if (action.equals("logout")) {
			HttpSession session = request.getSession();
			if(session != null && session.getAttribute("user")!=null) {
				session.removeAttribute("user");
				session.invalidate();
			}
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
