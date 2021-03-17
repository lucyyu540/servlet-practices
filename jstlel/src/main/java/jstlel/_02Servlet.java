package jstlel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/02")
public class _02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * SCOPE order
		 * applicatioon (context) > session > request> page
		 * 
		 * el search order
		 * page --> request --> session --> application
		 * 
		 */
		User vo = new User();
		vo.setName("Lucy request");
		request.setAttribute("vo", vo);
		User vo2 = new User();
		vo2.setName("Lucy session ");
		request.getSession().setAttribute("vo", vo2);
		request.getRequestDispatcher("/WEB-INF/view/02.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
