package net.azib.java.students.t030655.Lab4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * FileDisplayer
 *
 * @author Triin
 */
public class FileDisplayer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Reader reader = null;
		try {
			String filename = ".classpath";
			InputStream is = new BufferedInputStream(new FileInputStream(filename));
			reader = new InputStreamReader(is, "UTF-8");
			//Reader reader = new StringReader("Hello!");
			int c;
			while ((c = reader.read()) != -1)
				System.out.print((char)c);
			System.out.println();			
		}
		catch (IOException e){
			System.out.println("Unable to read data");
		}
		finally{
			try{
				reader.close();
			}
			catch (IOException e){
				//this should not happen
			}
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
