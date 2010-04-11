package net.azib.java.lessons.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

/**
 * FileReadingDemo
 *
 * @author anton
 */
public class FileReadingDemo {
	public static void main(String[] args) {
		new FileReadingDemo().main();
	}

	private void main() {
		Reader reader = null;
		try {
			reader = createReader();
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char)c);
			}
		}
		catch (IOException e) {
			System.err.println("Something bad happened");
		}
		finally {
			IOUtils.closeQuietly(reader);
		}
	}

	Reader createReader() throws IOException {
		return new InputStreamReader(new FileInputStream(".classpath"), "UTF-8");
	}
}
