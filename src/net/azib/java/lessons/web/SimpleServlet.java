package net.azib.java.lessons.web;

import net.azib.java.servlet.ServletLauncher;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		req.setCharacterEncoding("UTF-8");
		Integer count = (Integer) session.getAttribute("count");
		if (count == null)
			count = 0;
		String requestedCount = req.getParameter("count");
		count++;

		if (requestedCount != null) {
			count = new Integer(requestedCount);
		}
		
		session.setAttribute("count", count);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello World, " + count + " times</h1>");
		out.print("<form action='" + resp.encodeURL("/") + "'><input name='count' value='" + count + "'><input type='submit'></form>");
		out.print("<form action='" + resp.encodeURL("/") + "'><input type='submit' value='Refresh'></form>");
		out.close();
	}

	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}
}
