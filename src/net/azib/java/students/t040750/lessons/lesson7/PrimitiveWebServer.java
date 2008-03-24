package net.azib.java.students.t040750.lessons.lesson7;

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
 * @author t040750
 */
public class PrimitiveWebServer {
	/** HTTP_PORT */
	private static final int HTTP_PORT = 8080;
	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK" + HTTP_LN;
	
	public void handleRequest(InputStream input, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		try {
			if (reader.readLine().startsWith("GET ")) {
				out.write((HTTP_OK_RESPONSE +
							"Server: " + getClass().getSimpleName() + HTTP_LN +
							HTTP_LN + "Hello World!").getBytes());
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	private void closeQuietly(Socket socket) {
		if (socket != null) {
			ServerSocket server;
			try {
				server = new ServerSocket(HTTP_PORT);
				server.close();
			}
			catch (Exception e) {
				System.err.println("Socket close failed!");
			}
		}
	}
	
	public void run() throws IOException {
		ServerSocket server;
		try {
			server = new ServerSocket(HTTP_PORT);
		}
		catch (IOException e) {
			System.err.println("Unable to bind to port " + HTTP_PORT);
			return;
		}
		
		while (true) {
			Socket socket = new Socket();
			try {
				socket = server.accept();
				handleRequest(socket.getInputStream(), socket.getOutputStream());
			}
			catch (IOException e) {
				System.err.println("Request handling failed!");
			}
			finally {
				closeQuietly(socket);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		new PrimitiveWebServer().run(); 
	}
}
