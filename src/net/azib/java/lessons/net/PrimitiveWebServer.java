package net.azib.java.lessons.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PrimitiveWebServer
 *
 * @author anton
 */
public class PrimitiveWebServer {
	private static final String LN = "\r\n";
	
	public static void main(String[] args) {
		new PrimitiveWebServer().run();
	}

	private void run() {
		try {
			ServerSocket server = new ServerSocket(8080);
			
			System.err.println("Listening on port " + server.getLocalPort());
			
			while (true) {
				Socket socket = server.accept();
				BufferedReader reader = getReader(socket);
				String request = reader.readLine();
				dropHeaders(reader);
				System.err.println("Request from " + socket.getRemoteSocketAddress() + ": " + request);
				
				Writer writer = getWriter(socket);
				sendHeaders(writer);
				
				RequestHandler handler = new HelloWorldRequestHandler();
				handler.handle(request, writer);
				
				writer.close();
				socket.close();
			}
		}
		catch (IOException e) {
			// TODO !!
		}
		
	}

	private OutputStreamWriter getWriter(Socket socket) throws UnsupportedEncodingException, IOException {
		return new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
	}

	private BufferedReader getReader(Socket socket) throws UnsupportedEncodingException, IOException {
		return new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
	}

	private void dropHeaders(BufferedReader reader) throws IOException {
		String header;
		while ((header = reader.readLine()) != null) {
			if (header.isEmpty())
				break;
		}
	}

	private void sendHeaders(Writer writer) throws IOException {
		writer.write("HTTP/1.0 200 OK" + LN);
		writer.write("Content-Type: text/html; charset=UTF-8" + LN);
		writer.write(LN);
	}
}
