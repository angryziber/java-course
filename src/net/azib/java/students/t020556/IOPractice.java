package net.azib.java.students.t020556;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * FIleReader
 *
 * @author t020556
 */
public class IOPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException, FileNotFoundException{
		//String fileName = ".classpath";
		//Reader reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		Reader reader = new StringReader("Hello!");
		int c;
		while((c = reader.read()) >= 0)
			System.out.print((char)c);
		
		reader.close();
	}
}
