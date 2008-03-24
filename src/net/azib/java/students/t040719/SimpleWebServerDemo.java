package net.azib.java.students.t040719;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SimpleWebServerDemo
 *
 * @author t040719
 */
public class SimpleWebServerDemo {
	/** HTTP_PORT */
	private static final int HTTP_PORT = 8080;
	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK";

	/**
	 * @param input
	 * @param out
	 */
	public void handleRequest(InputStream input, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			if (reader.readLine().startsWith("GET ")){
				out.write((HTTP_OK_RESPONSE + 
							"Server: "+getClass().getSimpleName() + HTTP_LN +
							"Content-type: text/html" + HTTP_LN +
							HTTP_LN +
							"<h1>Hello World!</h1>").getBytes());
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeQuietly(Socket socket){
		if (socket != null){
			try {
				socket.close();
			}
			catch (IOException e) {

			}
		}
	}
	
	public void run(){
		ServerSocket srv;
		try {
			srv = new ServerSocket(HTTP_PORT);
		}
		catch (IOException e) {
			System.err.println("Unable to bind to port " + HTTP_PORT);
			return;
		}
		
		while(true){
			Socket socket = null;
			try{
				socket = srv.accept();
				handleRequest(socket.getInputStream(), socket.getOutputStream());
				socket.close(); //paneb ise ka kõik streamid kinni
			}
			catch (IOException e){
				System.err.println("Request handling failed!");
			}
			finally{
				closeQuietly(socket);
			}
		}		
	}
	
	public static void main(String[] args) throws IOException {
			new SimpleWebServerDemo().run();
	}

}
