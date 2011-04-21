package net.azib.java.students.t104607;
// @author 104607 IASM

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class FileReceiverServer {
	public static void main(String[] args) throws InterruptedException {
		Thread listener = new Thread() {
			@Override
			public void run() {
				ServerSocket server = null;
				int port = 16969;
				try {
					server = new ServerSocket(port);
					server.setSoTimeout(100);
				}
				catch (IOException e) {
					System.err.println("Failed to listen port " + port);
					System.exit(-1);
				}
				Socket client = null;
				while (!Thread.interrupted()) {
					try {
						client = server.accept();
						ReceiveFile receiveFile = new ReceiveFile(client);
						Thread receive = new Thread(receiveFile);
						receive.start();
					} catch (SocketTimeoutException e) {
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		listener.setDaemon(true);
		listener.start();
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		System.out.println("type 'exit' to close program");
		while (scanner.next().compareTo("exit") != 0);
		listener.interrupt();
		listener.join();
	}
}
