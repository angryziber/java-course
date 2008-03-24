package net.azib.java.students.t040719;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;


/**
 * SimpleWebServerDemoTest
 *
 * @author t040719
 */
public class SimpleWebServerDemoTest {
	private SimpleWebServerDemo webServ;
	
	@Test
	public void requestHandled(){
		webServ = new SimpleWebServerDemo();
		ByteArrayInputStream input = new ByteArrayInputStream("GET / HTTP/1.0\r\n\r\n".getBytes());
		//input.println("GET / HTTP/1.0");
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		webServ.handleRequest(input,out);
		//assertEquals(SimpleWebServerDemo.HTTP_OK_RESPONSE + "Server: " + webServ.getClass().getSimpleName(),);
	}
}
