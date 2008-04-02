package net.azib.java.students.t030633;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;

import org.junit.Test;

/**
 * SimpleRequestHandlerTest
 * 
 * @author t030633
 */
public class SimpleRequestHandlerTest {

	/* Test your server by starting it in a separate thread in a test class, 
	 * sending requests over a Socket and verifying its contents, 
	 * then interrupting the server.*/
	
	private SimpleRequestHandler handler;

	@Test
	public void requestHandled() throws Exception {

		handler = new SimpleRequestHandler(new Socket());
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP/1.0".getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		handler.handleRequest(input, output);

		assertEquals(SimpleRequestHandler.HTTP_OK_RESPONSE + SimpleRequestHandler.HTTP_LN + 
				"Server: " + SimpleWebServer.SERVER_NAME + SimpleRequestHandler.HTTP_LN +
				"Content-Type: text/html" + SimpleRequestHandler.HTTP_LN +
				SimpleRequestHandler.HTTP_LN + 
				"Hello World!", output.toString());

	}

}
