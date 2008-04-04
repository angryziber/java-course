package net.azib.java.students.t030633;

import net.azib.java.students.t030633.hometasks.copier.DirectChanneledCopyProgram;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

	private File getFile(File requested) throws IOException {

		// create a Socket
		Socket socket = new Socket(LOCALHOST, SimpleWebServer.HTTP_PORT);
		PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
		InputStream socketIn = socket.getInputStream();

		// send a request
		socketOut.println("GET /" + requested.getName() + " HTTP/1.0");

		// read the response into a file
		File response = FileLocations.DESTINATION_FILE;
		new DirectChanneledCopyProgram().copy(socketIn, new FileOutputStream(response));
		return response;

	}

	@Test
	public void testRun() throws IOException {

		// start SimpleWebServer in a thread
		Thread t = new Thread(new SimpleWebServer());
		t.start();

		assertEquals(FileLocations.SOURCE_FILE.length(), getFile(FileLocations.SOURCE_FILE).length());

		// interrupt our server
		t.interrupt();

	}

}
