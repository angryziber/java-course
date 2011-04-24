package net.azib.java.students.t103784;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class FileReceiverServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		new FileReceiverServer().start();
	}

	public void start() throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(1234);
		while (true) {
			Socket client = server.accept();
			System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
			new Thread(new Handler(client)).start();
			client.close();
		}
	}

	public class Handler implements Runnable {
		Socket client;


		public Handler(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {

			FileOutputStream out = null;
			try {
				DataInputStream in = new DataInputStream(client.getInputStream());
				int version = in.readInt();
				if (version != 2) {
					System.err.println("Unsupported protocol version " + version);
					return;
				}
				String filename = in.readUTF();
				File file = new File(System.getProperty("java.io.tmpdir"), filename);
				out = new FileOutputStream(file);
				IOUtils.copy(in, out);
				System.out.println("Received file " + file + " (" + file.length() + " bytes)");
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			} finally {
				IOUtils.closeQuietly(out);
				try {
					client.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
