package net.azib.java.students.t030636.v_04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * FileDisplayer
 *
 * @author Martin
 */
public class FileDisplayer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args)  {
		long startTime = System.currentTimeMillis(); 
		
		Reader reader = null;
		try {
			String filename = ".classpath";
			reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(filename)), "UTF-8");
	//		Reader reader = new StringReader("Hello!");
			
			int c;
			while((c = reader.read()) != -1)
				System.out.print((char)c);
			System.out.println();

		}
		catch (IOException e) {
			System.out.println("Unable to read data!");
		}
		finally {
			try {
				reader.close();				
			}
			catch(IOException e) {
				//this should not happen
			}

		}
		
		System.out.println("Program ran for " + (System.currentTimeMillis()- startTime) +"ms" );
	}
}
