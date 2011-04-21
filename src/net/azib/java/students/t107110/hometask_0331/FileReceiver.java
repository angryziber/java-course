package net.azib.java.students.t107110.hometask_0331;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Eduard Shustrov
 */
public class FileReceiver implements Runnable {
	private final Socket socket;

	public FileReceiver(final Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream socketStream = null;
			try {
				socketStream = new DataInputStream(socket.getInputStream());
				readProtocolVersion(socketStream);
				final String fileName = readFileName(socketStream);
				saveToFile(socketStream, fileName);
			} finally {
				if (socketStream != null) socketStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int readProtocolVersion(final DataInputStream inputStream) throws IOException {
		final int protocolVersion = inputStream.readInt();
		if (protocolVersion != 1)
			throw new IOException("Protocol version is not supported: " + protocolVersion);
		return protocolVersion;
	}

	private static String readFileName(final DataInputStream inputStream) throws IOException {
		return inputStream.readUTF();
	}

	private static void saveToFile(final InputStream inputStream, final String fileName) throws IOException {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(fileName);
			new BufferedCopyProgram().copy(inputStream, outputStream);
		} finally {
			if (outputStream != null) outputStream.close();
		}
	}
}
