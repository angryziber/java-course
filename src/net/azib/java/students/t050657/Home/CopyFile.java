package net.azib.java.students.t050657.Home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CopyFile
 *
 * @author t050657
 */
public class CopyFile {

	/**
	 * Copy file programm. In general case it works, but has a lot of lacks.
	 * 
	 * Main problem is that you can't enter as argument path with spaces(' ').
	 * For doing it become necessary to write analyzer to build right path from many pieces. 
	 * It make small programm much complicate.
	 * 
	 * The second problem that I tried to read and write to file by lines.
	 * It causes problems with encodings. Tried to add Unicode new line symbol to end of each line 
	 * and set charset, but also don't work. 
	 * It can't be that only one decision is read and write by characters 8))
	 * 
	 * @param args programm takes two arguments. First - path to file to copy, 
	 * second - path to file to write content.  
	 */
	public static void main(String[] args) {

		String from = args[0];
		String to = args[1];

		copyFile(from, to);

	}
	
	public static void copyFile(String from, String to) {
		char newLine = '\u2424';
		long start = System.currentTimeMillis();
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			/*
			reader = new BufferedReader(new InputStreamReader(
									      	new FileInputStream(from), "Unicode"));
			writer = new BufferedWriter(new OutputStreamWriter(
											new FileOutputStream(to), "Unicode"));
			*/
			
			reader = new BufferedReader(new FileReader(from));
			writer = new BufferedWriter(new FileWriter(to));
			
			int c;
			while( (c = reader.read()) >= 0 ) 
				writer.write((char)c);

			/*
			while(reader.ready()) {
				writer.write(reader.readLine());
				writer.write(newLine);
			}
			*/
		}
		catch(FileNotFoundException e) {
			System.out.println("File to copy not found!");
		}
		catch(IOException e) {
			System.out.println("Incorrect name to copy of file!");
		}
		finally {
			try {
				reader.close();
				writer.close();
			}
			catch(IOException e) {
				// this should not happen
			}
		}
		
		System.out.println("Timer: "  + (System.currentTimeMillis() - start));
		
	}

}
