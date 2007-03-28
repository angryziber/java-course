package net.azib.java.lessons.net;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.Socket;

import org.junit.Test;

/**
 * SimpleWebServerTest
 *
 * @author anton
 */
public class SimpleWebServerTest {
	
	@Test
	public void testHandleRequest() throws Exception {
		RequestHandler requestHandler = createMock(RequestHandler.class);
		
		Socket socket = new TestSocket();

		expect(requestHandler.cloneForRequest(socket)).andReturn(requestHandler);
		expect(requestHandler.readRequest()).andReturn(null);
		requestHandler.writeResponse();
		
		replay(requestHandler);
				
		SimpleWebServer server = new SimpleWebServer(requestHandler);
		server.handleRequest(socket);
		
		verify(requestHandler);
		assertTrue(closeCalled);
	}
	
	private boolean closeCalled = false;
	private class TestSocket extends Socket {
		@Override
		public synchronized void close() throws IOException {
			super.close();
			closeCalled = true;
		}
	}
	
}
