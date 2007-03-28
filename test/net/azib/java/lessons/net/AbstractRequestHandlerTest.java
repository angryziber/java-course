package net.azib.java.lessons.net;

import static org.junit.Assert.*;

import net.azib.java.lessons.net.AbstractRequestHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;


/**
 * AbstarctRequestHandlerTest
 *
 * @author anton
 */
public class AbstractRequestHandlerTest {
	
	protected ByteArrayOutputStream output;
	protected RequestHandler requestHandler;
	
	@Before
	public void createRequestHandler() {
		requestHandler = new EchoRequestHandler();
		requestHandler = requestHandler.cloneForRequest(new TestSocket("GET /ultimateAnswer.html HTTP/1.0\n\n"));
	}
	
	@Test
	public void testReadRequest() throws Exception {
		assertEquals("/ultimateAnswer.html", requestHandler.readRequest());
	}

	@Test
	public void testClone() throws Exception {
		AbstractRequestHandler rh = new AbstractRequestHandler() {
			public String readRequest() { return null; }
			public void writeResponse() { }
		};
		assertNotSame(rh, rh.cloneForRequest(new Socket()));
		assertEquals(rh.getClass(), rh.cloneForRequest(new Socket()).getClass());
	}
	
	/**
	 * Socket for testing of RequestHandlers.
	 *
	 * @author anton
	 */
	protected class TestSocket extends Socket {
		private String requestString;
		
		public TestSocket(String requestString) {
			this.requestString = requestString;
		}

		@Override
		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(requestString.getBytes(AbstractRequestHandler.ENCODING));
		}

		@Override
		public OutputStream getOutputStream() throws IOException {
			output = new ByteArrayOutputStream();
			return output;
		}		
	}
}
