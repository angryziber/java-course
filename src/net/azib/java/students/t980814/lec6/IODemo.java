package net.azib.java.students.t980814.lec6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IODemo
 * 
 * @author dell
 */
public class IODemo {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null)
				System.out.println(line);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		finally {
			if (reader != null)
				reader.close();
			System.out.println("Closed.");
		}
	}
}
