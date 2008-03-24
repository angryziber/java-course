package net.azib.java.lessons.io;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * PrimitiveWebServerTest
 *
 * @author anton
 */
public class PrimitiveWebServerTest {
	
	private PrimitiveWebServer webServer;
	
	@Test
	public void requestHandled() throws Exception {
		webServer = new PrimitiveWebServer();
		
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP/1.0\n\n".getBytes());
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		webServer.handleRequest(input, out);
		assertEquals(PrimitiveWebServer.HTTP_OK_RESPONSE + 
					 "Server: " + webServer.getClass().getSimpleName() + PrimitiveWebServer.HTTP_LN +
					 "Content-Type: text/html" + PrimitiveWebServer.HTTP_LN +
				     PrimitiveWebServer.HTTP_LN + 
				     "<h1>Hello World!</h1>", out.toString());
				     		
	}

}







