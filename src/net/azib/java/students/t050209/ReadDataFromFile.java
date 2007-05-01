package net.azib.java.students.t050209;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * ReadDataFromFile
 *
 * @author t050209
 */
public class ReadDataFromFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		
		Reader reader = null;
		try {
			String filename = ".classpath";
			reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(filename)));
			//Reader reader = new InputStreamReader(is, "UTF-8");
		
			//StringReader reader = new StringReader("Hello!");
			int c;
			while((c = reader.read()) != -1)
				System.out.print((char)c);
			System.out.println();
		}
		
		finally {
			
		System.out.println(System.currentTimeMillis() - startTime);
		reader.close();
		}
	}

}
