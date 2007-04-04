package net.azib.java.students.t020632;

import java.net.Socket;

/**
 * SimpleWebServer
 *
 * @author t020632
 */
public interface RequestHandler {
	void readRequest();
	void writeResponse();
	RequestHandler cloneForRequest(Socket socket);
}
