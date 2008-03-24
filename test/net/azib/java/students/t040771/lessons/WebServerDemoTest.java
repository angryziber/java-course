package net.azib.java.students.t040771.lessons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * WebServerDemoTest
 *
 * @author t040771
 */
public class WebServerDemoTest {
	
	private WebServerDemo srv;

	@Test
	public void emptyTest() {
		
	}
/*	
	@Test
	public void requestHandled() {
		srv = new WebServerDemo();
		PrintStream input = new PrintStream(new ByteArrayInputStream());
		input.println("GET / HTTP/1.0");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		srv.handleRequest(input, out);
		assertEquals(WebServerDemo.HTTP_OK_RESPONSE + "Server: " + WebServerDemo.getClass() + "\r\n\r\nHelloWorld!", out.toString);
	}
*/
}
