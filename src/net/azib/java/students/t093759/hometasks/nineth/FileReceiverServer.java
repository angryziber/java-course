package net.azib.java.students.t093759.hometasks.nineth;

import java.io.IOException;
import java.net.ServerSocket;
//TODO test this class

/**
 * @author dionis
 *         4/21/11 1:16 PM
 */
public class FileReceiverServer {

	public final static int PORT = 8080;

	public void run() throws IOException {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(PORT);
			handle(serverSocket);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (serverSocket != null) serverSocket.close();
		}
	}

	private void handle(ServerSocket serverSocket) throws IOException {
		while (true) {
			new Thread(new SimpleFileReceiveServerRequestHandler(serverSocket.accept())).start();
		}
	}

	public static void main(String[] args) throws IOException {
		new FileReceiverServer().run();
	}
}
