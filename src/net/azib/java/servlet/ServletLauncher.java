package net.azib.java.servlet;

import org.mortbay.http.HttpContext;
import org.mortbay.http.SocketListener;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;

/**
 * A simple starter utility class for Java Servlets using 
 * the Jetty lightweight application server.
 * 
 * @author anton
 */
public class ServletLauncher {
	
	public static void main(String ... args) throws Exception {
		
		if (args.length == 0) {
			throw new IllegalArgumentException("Please specify servlet class name!");
		}
		
		String servletPath = args.length >= 2 ? args[1] : "/*";
		String servletClassName = args[0];
		
		Server server = new Server();
		SocketListener listener = new SocketListener();
		listener.setPort(8080); 
		server.addListener(listener);
		
		HttpContext context = new HttpContext();
		context.setContextPath("/");
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServlet(servletPath, servletClassName );
		context.addHandler(servletHandler);
		server.addContext(context);

		server.start();
	}
}
