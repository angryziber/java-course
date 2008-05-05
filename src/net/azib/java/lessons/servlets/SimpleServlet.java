package net.azib.java.lessons.servlets;

import net.azib.java.servlet.ServletLauncher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

/**
 * SimpleServlet
 *
 * @author anton
 */
public class SimpleServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("logout") != null) {
			session.invalidate();
			session = request.getSession();
		}
		
		String name = request.getParameter("name");
		if (name != null) {
			session.setAttribute("name", name);
		}
		else {
			name = (String) session.getAttribute("name");
		}
		
		Integer counter = (Integer) session.getAttribute("counter");
		if (counter == null) {
			counter = 1;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello " + (name != null && !name.isEmpty() ? name : "World") + "!!!</h1>");
		out.println("<h4>Request #" + counter + "</h4>");
		out.println("<form action='" + response.encodeURL("/") + "'>");
		out.println("<input type='text' name='name'/>");
		out.println("<input type='submit' name='change' value='Change name'/>");
		out.println("<br/><input type='submit' name='logout' value='Logout!'/>");
		out.println("</form>");
		out.close();
		
		session.setAttribute("counter", ++counter);
	}

	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}
}
