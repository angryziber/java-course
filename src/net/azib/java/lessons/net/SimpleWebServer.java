package net.azib.java.lessons.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A simple web server implementation that uses {@link RequestHandler} implementations
 * to handle requests from clients.
 *
 * @author anton
 */
public class SimpleWebServer implements Runnable {
	
	/** Prototype of a RequestHandler implementation. Cloned for handling of each request. */
	private RequestHandler requestHandlerPrototype;

	/**
	 * Constructs the server.
	 * @param requestHandler the prototype request handler that will be cloned
	 * for handling of each request
	 */
	public SimpleWebServer(RequestHandler requestHandler) {
		requestHandlerPrototype = requestHandler;
	}

	/**
	 * Initiates request handling using a clone of requestHandlerPrototype
	 * @param socket
	 */
	void handleRequest(Socket socket) {
		// TODO: better error handling is needed to keep server running in case of exceptions
		try {
			RequestHandler requestHandler = requestHandlerPrototype.cloneForRequest(socket);
			requestHandler.readRequest();
			requestHandler.writeResponse();
		}
		finally {
			try {
				socket.close();
			}
			catch (IOException e) {
				// ignore :-)
			}
		}
	}

	/**
	 * The method to run the server process.
	 * This method never returns.
	 */
	public void run() {
		try {
			ServerSocket server = new ServerSocket(8080);
			while (true) {
				Socket socket = server.accept();
				handleRequest(socket);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleWebServer(new EchoRequestHandler()).run();
	}

}
