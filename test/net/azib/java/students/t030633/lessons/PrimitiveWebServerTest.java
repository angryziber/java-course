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
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		server.handleRequest(input, out);
		
		assertEquals("HTTP 200 OK"+ PrimitiveWebServer.HTTP_LN+"Server: "+ server.getClass().getSimpleName()+"\r\nHello World!", out.toString());
	}
}
