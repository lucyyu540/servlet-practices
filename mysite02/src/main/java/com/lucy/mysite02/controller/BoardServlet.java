package com.lucy.mysite02.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.mysite02.dao.BoardDao;
import com.lucy.mysite02.dao.GuestBookDao;
import com.lucy.mysite02.model.BoardVo;
import com.lucy.mysite02.model.GuestVo;
import com.lucy.mysite02.model.UserVo;

//response.sendRedirect(request.getContextPath());
//request.getRequestDispatcher("/WEB-INF/view/user/loginform.jsp").forward(request, response);
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] actions = request.getRequestURI().split("/");
		String action = actions[actions.length-1];
		if(action.equals("view")) {//guestbook/deleteform
			int no = Integer.parseInt(request.getParameter("no"));
			new BoardDao().updateCount(no);//조회수 ++
			BoardVo board = new BoardDao().select(no);
			request.getSession().setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/view/board/view.jsp").forward(request, response);;
		}
		else if(action.equals("modifyform")) {//guestbook/deleteform
			request.getRequestDispatcher("/WEB-INF/view/board/modify.jsp").forward(request, response);;
		}
		else if(action.equals("modify")) {//guestbook/delete
			//read from request
			int id = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("password");
			System.out.println(id + " " + pw);
			//deleteing from db
			new GuestBookDao().delete(id, pw);
			//redirect
			response.sendRedirect(request.getContextPath()+"/guestbook");

		}
		else if(action.equals("addform")) {//board/addform
			//redirect
			request.getRequestDispatcher("/WEB-INF/view/board/write.jsp").forward(request, response);;
		}
		else if(action.equals("add")) {//board/add
			//reading data from request
			UserVo u = (UserVo) request.getSession().getAttribute("user");
			int no = u.getNo();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//saving to db
			new BoardDao().create(new BoardVo(no, title, content));
			//redirect
			response.sendRedirect(request.getContextPath()+"/guestbook");
		}
		else {// /guestbook
			List<BoardVo> l = new BoardDao().selectAll();
			request.setAttribute("boards", l);
			//forward
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
