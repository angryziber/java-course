package net.azib.java.students.t030633.hometasks.server;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * AbstractRequestHandler
 * 
 * @author t030633
 */
public abstract class AbstractRequestHandler implements RequestHandlerInterface, Runnable {

	private Socket socket;
	protected int capacity; // socket send buffer size

	public AbstractRequestHandler(Socket s) {
		this.socket = s;
		try {
			capacity = s.getSendBufferSize();
		}
		catch (SocketException e) {
			System.err.println("Protocol error.");
		}
	}

	private void closeQuietly(Socket socket) {
		if (socket != null)
			try {
				socket.close();
			}
			catch (IOException e) {
				System.err.println("Unable to close socket " + socket.toString());
			}
	}

	public void run() {
		try {
			handleRequest(socket.getInputStream(), socket.getOutputStream());
		}
		catch (IOException e) {
			System.err.println("Handling failed.");
		}
		finally {
			closeQuietly(socket);
		}
	}

}
