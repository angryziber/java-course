package net.azib.java.students.t030633;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.junit.Test;

/**
 * SimpleWebServerTest
 * 
 * @author t030633
 */
public class SimpleWebServerTest {

	private static final String LOCALHOST = "127.0.0.1";

	private StringBuffer getFile() throws IOException {
		
		// create a Socket
		Socket socket = new Socket(LOCALHOST, SimpleWebServer.HTTP_PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// send an HTTP request
		out.println("GET /" + FileLocations.SOURCE_FILE.getName() + " HTTP/1.0");

		// read the response
		StringBuffer sb = new StringBuffer(socket.getReceiveBufferSize());
		int ch = 0;
		while ((ch = in.read()) != -1)
			sb.append((char) ch);
		return sb;
		
	}

	@Test
	public void testRun() throws IOException {

		// start SimpleWebServer in a thread
		Thread t = new Thread(new SimpleWebServer());
		t.start();

		StringBuffer sb = getFile();

		// interrupt our server
		t.interrupt();

		assertTrue(sb.length() == FileLocations.SOURCE_FILE.length());

	}

}
