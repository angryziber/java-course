package net.azib.java.students.t103784;

import org.apache.commons.io.IOUtils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
		ServerSocket server = new ServerSocket(7865);
		while (true) {
			Socket client = server.accept();
			System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
			handle(client);
			client.close();
		}
	}

	void handle(Socket client) throws IOException, InterruptedException {
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
		}
		finally {
			IOUtils.closeQuietly(out);
			client.close();
		}
	}
}
