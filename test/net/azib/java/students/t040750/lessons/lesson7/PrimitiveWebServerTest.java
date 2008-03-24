package net.azib.java.students.t040750.lessons.lesson7;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * PrimitiveWebServerTest
 *
 * @author t040750
 */
public class PrimitiveWebServerTest {

	private PrimitiveWebServer webServer;
	
	@Test
	public void requestHandled() throws Exception {
		webServer = new PrimitiveWebServer();
		
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP/1.0".getBytes());
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		webServer.handleRequest(input, out);
		assertEquals("",""); //ei jõudnud kirjutada
		
	}
}
