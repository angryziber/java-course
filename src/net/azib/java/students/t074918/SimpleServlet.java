package net.azib.java.students.t074918;

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
 * @author mart
 */
public class SimpleServlet extends HttpServlet {
	
	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.isNew())
			session.setAttribute("count", 1);
			
		int count = Integer.parseInt(req.getParameter("count")) + 1;
		
		Writer w = resp.getWriter();
		w.write("uhuu " + count);
		w.close();
		
		session.setAttribute("count", count);
	}
	

}
