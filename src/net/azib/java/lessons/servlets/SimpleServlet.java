package net.azib.java.lessons.servlets;

import net.azib.java.servlet.ServletLauncher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String name;
		
		if (session.isNew()) {
			name = request.getParameter("name");
			name = name != null ? name : request.getRemoteHost();
			session.setAttribute("name", name);
		}
		else {
			name = (String) session.getAttribute("name");
		}
		
		response.addHeader("My-Header", "123");
		//response.addCookie(new Cookie("abc", "123"));
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		PrintWriter writer = response.getWriter();
		writer.write("Hello ");
		writer.write(name);
		writer.write("!");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				writer.write("<br>");
				writer.write(cookie.getName() + "=" + cookie.getValue());
			}
		}
		writer.write("<br>You are using: " + request.getHeader("User-Agent"));
		writer.println("<br>");
		writer.write(session.isNew() ? "New user!" : "Welcome back!");
		writer.write("<br><br><a href='" + response.encodeURL(request.getServletPath()) + "'>Refresh</a>");
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		ServletLauncher.main(SimpleServlet.class.getName(), "/hello");
	}

}
