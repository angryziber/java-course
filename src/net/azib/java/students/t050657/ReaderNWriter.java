package net.azib.java.students.t050657;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * ReaderNWriter
 *
 * @author t050657
 */
public class ReaderNWriter {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String file = ".classpath";
		Reader reader = null;
		
		try {
			//BufferedReader reader = new BufferedReader(new FileReader(file));
			//InputStream is = new FileInputStream(file);
			//BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			reader = new StringReader("Hello!");
			int c;
			while( (c = reader.read()) >= 0 ) 
				System.out.print((char)c);
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		catch(IOException e) {
			System.out.println("Cannot read line!");
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
