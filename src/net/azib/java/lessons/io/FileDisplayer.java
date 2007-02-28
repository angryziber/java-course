package net.azib.java.lessons.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * FileDisplayer
 *
 * @author anton
 */
public class FileDisplayer {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Reader reader = null;
		try {
			String filename = ".classpath";
			reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(filename)), "UTF-8");
			//StringReader reader = new StringReader("Hello!");
			int c;
			while ((c = reader.read()) != -1) 
				System.out.print((char)c);
			System.out.println();
		}
		catch (IOException e) {
			System.out.println("Unable to read data");
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				// this should not happen
			}
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
