package net.azib.java.students.t030633.lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PrimitiveWebServer
 * 
 * @author t030633
 */
public class PrimitiveWebServer {

	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK";
	public static final int HTTP_PORT = 8080;

	public void handleRequest(InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try {
			if (reader.readLine().startsWith("GET ")) {
				out.write((HTTP_OK_RESPONSE + HTTP_LN + "Server: " + getClass().getSimpleName() + HTTP_LN + "Hello World!")
						.getBytes());
			}
		}
		catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new PrimitiveWebServer().run();
	}

	private void closeQuietly(Socket socket) {

		if (socket != null)
			try {
				socket.close();
			}
			catch (IOException e) {
			}

	}

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
				handleRequest(socket.getInputStream(), socket.getOutputStream());
			}
			catch (IOException e) {
				System.err.println("Request failed.");
			}
			finally {
				if (socket != null)
					closeQuietly(socket);
			}
		}

	}

}
