package jstlel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _03Servlet
 */
@WebServlet("/03")
public class _03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> l = new ArrayList<User>();
		User o1 = new User();
		o1.setName("one");
		User o2 = new User();
		o2.setName("two");
		User o3 = new User();
		o3.setName("three");
		l.add(o1);
		l.add(o2);
		l.add(o3);
		request.setAttribute("list", l);
		request.getRequestDispatcher("/WEB-INF/view/03.jsp").forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
