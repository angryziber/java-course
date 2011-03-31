package net.azib.java.lessons.io;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;

public class ReadingDemo {
	public static void main(String[] args) throws IOException {
		copyBytes(new FileInputStream("build.xml"), System.out);
		copyBytes(new URL("http://www.ee/").openStream(), System.out);
		copyBytes(new ByteArrayInputStream("Hellõ World".getBytes()), System.out);
		copyBytes(System.in, System.out);
	}

	private static void copyBytes(InputStream input, OutputStream output) throws IOException {
		input = new BufferedInputStream(input);
		try {
			int b;
			while((b = input.read()) != -1) {
				output.write((byte)b);
			}
		}
		finally {
			IOUtils.closeQuietly(input);
			output.flush();
		}
	}
}
