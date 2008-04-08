package net.azib.java.students.t030633.hometasks.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Request handler interface for the simple web server.
 *
 * @author t030633
 */
public interface RequestHandlerInterface {
	
	/**
	 * Handles a web server request.
	 * @param in - request stream
	 * @param out - response stream
	 * @throws IOException if handling fails
	 */
	public void handleRequest(InputStream in, OutputStream out) throws IOException;

}
