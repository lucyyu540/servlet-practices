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
			request.setAttribute("board", new BoardDao().select(no));
			request.getRequestDispatcher("/WEB-INF/view/board/view.jsp").forward(request, response);;
		}
		else if(action.equals("modifyform")) {//guestbook/deleteform
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("board", new BoardDao().select(no));
			request.getRequestDispatcher("/WEB-INF/view/board/modify.jsp").forward(request, response);;
		}
		else if(action.equals("modify")) {//guestbook/delete
			//read from request
			int id = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardVo b = new BoardVo();
			b.setNo(id);
			b.setTitle(title);
			b.setContent(content);
			new BoardDao().update(b);
			//redirect
			response.sendRedirect(request.getContextPath()+"/board");

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
			int g_no = request.getParameter("g_no").equals("") ? 0 : Integer.parseInt(request.getParameter("g_no"));
			int o_no =  request.getParameter("o_no").equals("") ? 1 : Integer.parseInt(request.getParameter("o_no"));
			int depth =  request.getParameter("depth").equals("") ? 1 : Integer.parseInt(request.getParameter("depth"));
			BoardVo b = new BoardVo(no, title, content);
			b.setG_no(g_no);
			b.setO_no(o_no);
			b.setDepth(depth);
			//saving to db
			new BoardDao().create(b);
			//redirect
			response.sendRedirect(request.getContextPath()+"/board");
		}
		else if(action.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			new BoardDao().delete(no);
			response.sendRedirect(request.getContextPath()+"/board");
		}
		else if(action.equals("search")) {
			String msg = request.getParameter("msg");
			int p = request.getParameter("p") == null ? 1 : Integer.parseInt("p");
			
			List<BoardVo> l  = new BoardDao().selectAll(msg, p);
			int pagesCount = new BoardDao().selectRowCount(msg);
			
			request.setAttribute("boards", l);
			request.setAttribute("pagesCount", pagesCount);
			//forward
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);;

		}
		else {// /guestbook
			BoardDao dao = new BoardDao();
			int page = request.getParameter("p") == null ? 1 : Integer.parseInt(request.getParameter("p"));
			int pagesCount = (dao.selectRowCount() / dao.linesPerPage) + 1 ;
			
			List<BoardVo> l = new BoardDao().selectAll(page);
			request.setAttribute("boards", l);
			request.setAttribute("pagesCount", pagesCount);
			//forward
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
