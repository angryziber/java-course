package net.azib.java.students.t040771.lessons;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
*/
/**
 * WebServerDemo
 *
 * @author t040771
 */
public class WebServerDemo {
	public static final String HTTP_LN = "\r\n";
	public static final int HTTP_PORT = 8080;
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK\r\n" + HTTP_LN;
/*	
	public void handleRequest(InputStream input, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader());
			if (reader.readLine().startsWith("GET ")) {
				out.write("HTTP_OK_RESPONSE");
			}
			
		}
		catch (Exception e) {
			
		}
	}
	
	private void closeQuietly(Socket socket) {
		if(socket != null) {
			try {
				socket.close();
			}
			catch (Exception e) {
				
			}
		}
	}
	
	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(HTTP_PORT);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		while(true) {
			Socket socket = null;
			try {
				socket = server.accept();
				handleRequest(socket.getInputStream(), socket.getOutputStream());
			}
			catch (IOException e) {
				System.err.println("Request handling failed");
			}
			finally {
				closeQuietly(socket);
			}
		}
	}
	
	public static void main(String[] args) {
		new WebServerDemo().run();
	}
*/
}
