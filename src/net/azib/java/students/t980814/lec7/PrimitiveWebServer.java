package net.azib.java.students.t980814.lec7;

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
 * @author dell
 */
public class PrimitiveWebServer {

	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK";
	public static final int HTTP_PORT = 8000;

	
	/**
	 * @param input
	 * @param out
	 */
	public void handleRequest(InputStream input, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			if (reader.readLine().startsWith("GET"))
				out.write((HTTP_OK_RESPONSE + HTTP_LN +
						   "Server: " + getClass().getSimpleName() + HTTP_LN +
						   "Content-Type: text/html" + HTTP_LN +
						   HTTP_LN + 
						   "<hl>Hello World!<hl>").getBytes());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.err.println("Unable to bind port " + HTTP_PORT);
			return;
		}
		
		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
				handleRequest(socket.getInputStream(), socket.getOutputStream());
			}
			catch (IOException e) {
				System.err.println("Request handling failed.");
			}
			finally {
				closeQuietly(socket);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new PrimitiveWebServer().run();
	}
}
