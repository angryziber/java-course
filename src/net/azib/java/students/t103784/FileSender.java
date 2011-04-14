package net.azib.java.students.t103784;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class FileSender {
	private static final int VERSION = 2;

	public static boolean provide(String fileName, OutputStream out) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) return false;

		FileInputStream in = new FileInputStream(file);
		IOUtils.copy(in, out);
		in.close();
		return true;
	}

	public static void main(String[] args) throws IOException {
		String filename = "build.xml"; // args[0]
		Socket socket = new Socket("localhost", 7865);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(VERSION + 1);
		out.writeUTF(filename);
		provide(filename, out);
		socket.close();
	}
}
