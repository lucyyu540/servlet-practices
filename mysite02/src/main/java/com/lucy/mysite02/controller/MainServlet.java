package com.lucy.mysite02.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//			response.sendRedirect(request.getContextPath());
//			request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		System.out.println("init() called");
		System.out.println(this.getServletConfig().getInitParameter("config"));
		super.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() called");
		super.service(req, resp);
	}
	@Override
	public void destroy() {
		System.out.println("destroy() called");
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget() called");
		int visitCount = 0;
		// read cookies
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>0) {
			for(Cookie c : cookies) {
				if(c.getName().equals("visitCount")) visitCount = Integer.parseInt(c.getValue());
			}
		}
		// write cookies
		Cookie c =  new Cookie("visitCount", String.valueOf(++visitCount));
		c.setPath(request.getContextPath());
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		System.out.println("***visit count : " + visitCount);
		
		request.getRequestDispatcher("/WEB-INF/view/main/index.jsp").forward(request, response);			

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
