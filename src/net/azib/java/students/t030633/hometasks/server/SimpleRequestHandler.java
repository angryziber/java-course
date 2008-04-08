package net.azib.java.students.t030633.hometasks.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * SimpleRequestHandler
 * 
 * @author t030633
 */
public class SimpleRequestHandler extends AbstractRequestHandler {

	public SimpleRequestHandler(Socket s) {
		super(s);
	}

	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK";

	public void handleRequest(InputStream in, OutputStream out) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		if (reader.readLine().startsWith("GET ")) {
			out.write((HTTP_OK_RESPONSE + HTTP_LN + 
					"Server: " + SimpleWebServer.SERVER_NAME + HTTP_LN + 
					"Content-Type: text/html" + HTTP_LN + HTTP_LN + 
					"Hello World!").getBytes());
		}

	}

}
