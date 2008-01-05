package net.azib.java.lessons.net;

import java.net.Socket;

/**
 * RequestHandler - an interface for handling requests 
 * and sending responses in {@link SimpleWebServer}.
 * <p/>
 * SimpleWebServer receives a prototype instance of this interface on
 * creation and then clones its instances for each new request.
 *
 * @author anton
 */
public interface RequestHandler {
	
	/**
	 * Clones this instance in order to handle a new request.
	 * @param socket client socket with request data
	 * @return cloned instance
	 */
	RequestHandler cloneForRequest(Socket socket);
	
	/**
	 * Reads and parses the request data from the InputStream
	 * obtained from the socket passed during cloning. 
	 * @return requested file path (e.g. "/") by the client
	 */
	String readRequest();
	
	/**
	 * Writes response back to the client. What exactly is returned depends
	 * on the concrete implementation. 
	 */
	void writeResponse();
}
