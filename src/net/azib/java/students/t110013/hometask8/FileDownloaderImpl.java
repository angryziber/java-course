package net.azib.java.students.t110013.hometask8;

import net.azib.java.lessons.io.FileDownloader;
import net.azib.java.students.t110013.hometask7.SimpleBufferedCopyProgram;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Vadim
 * @see ApacheCommonsPoweredFileDownloaderImpl
 */
public class FileDownloaderImpl implements FileDownloader {
	private int connectionTimeout;
	private int readTimeout;

	public FileDownloaderImpl() {
	}

	public FileDownloaderImpl(int connectionTimeout, int readTimeout) {
		this.connectionTimeout = connectionTimeout;
		this.readTimeout = readTimeout;
	}

	@Override
	public void download(URL url, File destDir) throws IOException {
		InputStream in = null;
		OutputStream out = null;

		URLConnection connection = url.openConnection();
		connection.setConnectTimeout(connectionTimeout);
		connection.setReadTimeout(readTimeout);

		String fileName = new File(url.getPath()).getName();

		try {
			in = connection.getInputStream();
			out = new FileOutputStream(new File(destDir, fileName));
			new SimpleBufferedCopyProgram().copy(in, out);
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
		}
	}
}
