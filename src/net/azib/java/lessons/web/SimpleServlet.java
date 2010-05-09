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
	}

	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName());
	}
}
