package net.azib.java.students.t110013.hometask9;

import org.apache.commons.io.IOUtils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vadim
 */
public class FileReceiverServerMultithreaded {

	public static void main(String[] args) throws IOException {
		new FileReceiverServerMultithreaded().go();
	}

	public void go() throws IOException {
		ServerSocket server = new ServerSocket(2700);

		while (!Thread.interrupted()) {
			Socket client = server.accept();
			System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

			new Thread(new ClientHandler(client)).start();

			System.out.println("End of loop.");
		}
	}

	public class ClientHandler implements Runnable {
		Socket client;

		public ClientHandler(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {
			System.out.println("New " + Thread.currentThread().getName() + " is up and running!");

			DataInputStream in = null;
			FileOutputStream out = null;

			try {
				in = new DataInputStream(client.getInputStream());

				String filename = in.readUTF();
				File file = new File(System.getProperty("java.io.tmpdir"), filename);

				out = new FileOutputStream(file);

				IOUtils.copy(in, out);
				System.out.println("Received file " + file + " (" + file.length() + " bytes)");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				IOUtils.closeQuietly(in); // should be closeQuietly(socket)
				IOUtils.closeQuietly(out);
			}

			System.out.println(Thread.currentThread().getName() + " finished its work.");
		}
	}
}
