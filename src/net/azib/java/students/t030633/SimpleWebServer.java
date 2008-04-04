package net.azib.java.students.t030633;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SimpleWebServer
 * 
 * @author t030633
 */
public class SimpleWebServer implements Runnable {

	public static final int HTTP_PORT = 8080;
	public static final String SERVER_NAME = "Simple Web Server - 030633";

	public void run() {

		ServerSocket server;
		
		try {
			server = new ServerSocket(HTTP_PORT);
		}
		catch (IOException e) {
			System.err.println("Unable to bind to port " + HTTP_PORT);
			return;
		}
		
		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
				// new Thread(new SimpleRequestHandler(socket)).start();
				new Thread(new FileRequestHandler(socket)).start();
			}
			catch (IOException e) {
				System.err.println("Request failed.");
			}
		}

	}
	
	public static void main(String[] args) {
		new SimpleWebServer().run();
	}

}
