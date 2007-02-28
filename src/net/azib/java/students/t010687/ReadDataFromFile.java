package net.azib.java.students.t010687;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * ReadDataFromFile
 *
 * @author t010687
 */
public class ReadDataFromFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String fileName = ".classpath";
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(fileName));
			Reader reader = new InputStreamReader(is,"UTF-8");
			//Reader reader = new FileReader(fileName);
			//StringReader reader = new StringReader("Hello!");
			int c;
			while ((c = reader.read()) != -1)
				System.out.print((char)c);
			System.out.println();
			reader.close();
		}
		catch (IOException e){
			
		}
	}

}
