package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * {@link RequestHandler} that echoes all the received headers back to the client.
 *
 * @author anton
 */
public class EchoRequestHandler extends AbstractRequestHandler {

	@Override
	public void writeResponse() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), ENCODING));
			out.println("HTTP/1.0 200 OK");
			out.println("Content-Type: text/plain; charset=" + ENCODING);
			out.println();
			out.print(requestString);
		}
		catch (IOException e) {
			throw new IllegalStateException("Cannot write :-(", e);
		}
		finally {
			out.flush();			
		}
	}

}
