package net.azib.java.students.t030633.lessons;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

/**
 * PrimitiveWebServerTest
 * 
 * @author t030633
 */
public class PrimitiveWebServerTest {

	private PrimitiveWebServer server;

	@Test
	public void requestHandled() throws Exception {

		server = new PrimitiveWebServer();
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP/1.0".getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		server.handleRequest(input, output);

		assertEquals(PrimitiveWebServer.HTTP_OK_RESPONSE + PrimitiveWebServer.HTTP_LN + 
				"Server: " + server.getClass().getSimpleName() + PrimitiveWebServer.HTTP_LN +
				"Content-Type: text/html" + PrimitiveWebServer.HTTP_LN +
				PrimitiveWebServer.HTTP_LN +
				"Hello World!", output.toString());

	}

}
