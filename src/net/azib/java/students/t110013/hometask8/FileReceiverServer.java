package net.azib.java.students.t110013.hometask8;

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
public class FileReceiverServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2700);

		while (true) {
			Socket client = server.accept();
			System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

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
			finally {
				client.close();
				if (out != null) out.close();
			}
		}
	}
}
