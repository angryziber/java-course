package net.azib.java.students.t110013.hometask8;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author Vadim
 */
public class FileSender {

	public static void main(String[] args) throws IOException {
		File file = new File("build.xml");
		Socket socket = new Socket("localhost", 2700);

		FileInputStream in = null;
		DataOutputStream out = null;

		try {
			in = new FileInputStream(file);
			out = new DataOutputStream(socket.getOutputStream());

			out.writeUTF(file.getName());
			IOUtils.copy(in, out);
		}
		finally {
			if (in != null) in.close();
			socket.close();
		}
	}
}
