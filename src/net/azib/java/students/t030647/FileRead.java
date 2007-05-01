package net.azib.java.students.t030647;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * FileRead
 *
 * @author t030647
 */
public class FileRead {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = ".classpath";
		Reader inp = new FileReader(file);
		System.out.println((char)inp.read());
		inp.close();
	}

}
