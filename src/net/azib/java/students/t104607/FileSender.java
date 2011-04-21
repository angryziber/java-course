package net.azib.java.students.t104607;
// @author 104607 IASM

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ConnectException;

public class FileSender {
	public static void main(String[] args) throws IOException {
		String filename = "build.xml"; // args[0]
		Socket socket = null;
		try {
			socket = new Socket("localhost", 16969);
		} catch (ConnectException e) {
			System.out.println("Server down");
			return;
		}
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(filename);
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("File doesn't exists");
			return;
		}
		FileInputStream in = new FileInputStream(file);
		IOUtils.copy(in, out);
		in.close();
		socket.close();
	}
}
