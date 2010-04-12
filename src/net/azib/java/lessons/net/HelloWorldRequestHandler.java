package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.Writer;

/**
 * RequestHandler
 *
 * @author anton
 */
public class HelloWorldRequestHandler implements RequestHandler {
	
	public void handle(String request, Writer writer) throws IOException {
		writer.write("<h1>You requested " + request + "</h1>");		
	}

}
