package net.azib.java.lessons.web;

import net.azib.java.servlet.ServletLauncher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getQueryString());
		String name = req.getParameter("name");
		if (name != null) {
			req.getSession().setAttribute("name", name);
		}
		if (name == null) {
			HttpSession session = req.getSession(false);
			if (session != null)
				name = (String) session.getAttribute("name");
		}

		if (name == null) name = "Wörld";

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write("<h1>Hello " + name + "!</h1>");
	}

	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}
}
