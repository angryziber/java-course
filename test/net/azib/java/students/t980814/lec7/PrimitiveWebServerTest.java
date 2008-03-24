package net.azib.java.students.t980814.lec7;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;


/**
 * PrimitiveWebServerTest
 *
 * @author dell
 */
public class PrimitiveWebServerTest {

	private PrimitiveWebServer webServer;
	
	@Test
	public void requestHandled() {
		webServer = new PrimitiveWebServer();
		
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP / 1.0".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		webServer.handleRequest(input, out);
		assertEquals(webServer.HTTP_OK_RESPONSE + webServer.HTTP_LN + "Server: " + webServer.getClass().getSimpleName() + webServer.HTTP_LN +
				   "Content-Type: text/html" + webServer.HTTP_LN +
				   webServer.HTTP_LN + "<hl>Hello World!<hl>", out.toString());
	}

}
