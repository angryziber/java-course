package net.azib.java.students.t020544;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * FileDisplayer
 * 
 * @author Julija Kondratjeva
 */
public class FileDisplayer {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException {
		Reader reader = null;
		long startTime=System.currentTimeMillis();
		String filename = ".classpath";
		 // Reader reader = new FileReader(filename);
		
		reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(filename)), "UTF-8");
//		InputStream is = new FileInputStream(filename);
//		 Reader reader = new InputStreamReader(is, "UTF-8"); // Reader reader = new InputStreamReader(is);
		

//		StringReader reader = new StringReader("Hello!");

		int c;
		while ((c =  reader.read()) != -1)
			System.out.print((char)c);
		System.out.println();
		reader.close();
		
		System.out.println(System.currentTimeMillis()-startTime);
	}

}
