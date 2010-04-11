package net.azib.java.lessons.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineBasedReading
 *
 * @author anton
 */
public class LineBasedReading {
	public static void main(String[] args) throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(".classpath"));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(reader.getLineNumber() + ". " + line);			
		}
	}
}
