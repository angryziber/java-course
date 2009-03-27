package net.azib.java.lessons.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

/**
 * FileIODemo
 *
 * @author anton
 */
public class FileIODemo {
	
	static PrintStream out = System.out;
	
	static void readAndDisplay(Reader reader) throws IOException {
		char[] buf = new char[4096];
		int len;
		while ((len = reader.read(buf)) != -1) {
			out.print(new String(buf, 0, len));
		}
	}
	
	public static void main(String[] args) {
		File inputFile = new File(".classpath");
		Reader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(createInputStream(inputFile), "UTF-8"));
			readAndDisplay(reader);
		}
		catch (FileNotFoundException e) {
			System.err.println("Cannot find " + inputFile.getAbsolutePath());
		}
		catch (IOException e) {
			System.err.println("Cannot read: " + e.getMessage());
		}
		finally {
			IOUtils.closeQuietly(reader);
		}
	}

	private static InputStream createInputStream(File inputFile) throws IOException {
		return new FileInputStream(inputFile);
	}
}
