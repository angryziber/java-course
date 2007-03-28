package net.azib.java.lessons.net;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * EchoRequestHandlerTest
 *
 * @author anton
 */
public class EchoRequestHandlerTest extends AbstractRequestHandlerTest {
		
	@Before @Override
	public void createRequestHandler() {
		requestHandler = new EchoRequestHandler();
		requestHandler = requestHandler.cloneForRequest(new TestSocket("GET /ultimateAnswer.html HTTP/1.0\n\n"));
	}
	
	@Test
	public void testWriteResponse() throws Exception {
		requestHandler.readRequest();
		requestHandler.writeResponse();
		assertEquals("HTTP/1.0 200 OK\nContent-Type: text/plain; charset=UTF-8\n\nGET /ultimateAnswer.html HTTP/1.0\n", new String(output.toByteArray()));
	}
}
