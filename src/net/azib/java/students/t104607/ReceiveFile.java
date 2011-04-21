package net.azib.java.students.t104607;
// @author 104607 IASM

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;

public class ReceiveFile implements Runnable {
	private Socket client;
	ReceiveFile(Socket client) {
		   this.client = client;
	}
	@Override
	public void run() {
		System.out.println("New client " + client.toString());
		FileOutputStream out = null;
		try {
			DataInputStream in = new DataInputStream(client.getInputStream());
			String filename = in.readUTF();
			File file = new File(System.getProperty("java.io.tmpdir"), filename);
			file.deleteOnExit();
			out = new FileOutputStream(file);
			IOUtils.copy(in, out);
			System.out.println("Received file " + file + " (" + file.length() + " bytes)");
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
