package net.azib.java.students.t093759.hometasks.nineth;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.students.t093759.hometasks.seventh.SimpleCopyProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

//TODO test this class

/**
 * Very bad implementation of File Sender.
 *
 * @author dionis
 *         4/21/11 1:24 PM
 */
public class FileSender {
	DataCopier dataCopier;
	private final String SERVER_ADDRESS = "127.0.0.1";

	public FileSender(DataCopier dataCopier) {
		this.dataCopier = dataCopier;
	}

	public void run(String fileName) throws IOException {
		Socket socket = new Socket(SERVER_ADDRESS, FileReceiverServer.PORT);
		File file = new File(fileName);
		dataCopier.copy(new FileInputStream(file), socket.getOutputStream());
		socket.close();
	}

	public static void main(String[] args) throws IOException {
		String fileName = "build.xml";
		if (args.length == 1) fileName = args[1];
		new FileSender(new SimpleCopyProgram()).run(fileName);
	}
}
