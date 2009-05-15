package net.azib.java.lessons.web;

import net.azib.java.servlet.ServletLauncher;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SimpleServlet
 *
 * @author anton
 */
public class SimpleServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
		
		int count = (Integer) session.getAttribute("count") + 1;
		
		resp.setContentType("text/html");
		Writer w = resp.getWriter();
		w.write("<h1>" + count + ": Hello World!</h1>");
		w.write("<form action='/'>");
//		w.write("<input type='hidden' name='count' value='" + count + "'/>");
		w.write("<input type='submit'/>");
		w.write("</form>");
		w.close();
		
		session.setAttribute("count", count);
	}

	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}
}
