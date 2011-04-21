package net.azib.java.students.t107110.hometask_0331;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Eduard Shustrov
 */
public class FileReceiverServer {
	private static final int ACCEPT_TIMEOUT = 500;

	private final ServerSocket serverSocket;

	public FileReceiverServer(final int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(ACCEPT_TIMEOUT);
	}

	public static void main(final String[] args) throws IOException {
		if (args.length == 0) throw new IllegalArgumentException("Listening port is not specified");
		if (args.length > 1) throw new IllegalArgumentException("More than one listening port are specified");

		new FileReceiverServer(Integer.valueOf(args[0])).listen();
	}

	private void listen() {
		while (!Thread.interrupted()) {
			try {
				final Socket socket = serverSocket.accept();
				new Thread(new FileReceiver(socket)).start();
			} catch (SocketTimeoutException ignored) {
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
