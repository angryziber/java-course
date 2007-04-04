package net.azib.java.students.t050657.Home;

import net.azib.java.lessons.net.RequestHandler;
import net.azib.java.lessons.net.SimpleWebServer;

/**
 * SimpleWebServerLauncher
 *
 * @author Boriss
 */
public class SimpleWebServerLauncher extends SimpleWebServer {

	public SimpleWebServerLauncher(RequestHandler requestHandler) {
		super(requestHandler);
	}
	
	public static void main(String[] args) {
		new SimpleWebServerLauncher(new FileRequestHandler()).run();
	}
}
