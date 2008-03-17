package net.azib.java.students.t040719;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * FileDemo
 *
 * @author t040719
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
		String line;
		while((line = reader.readLine())!=null){
			System.out.println(line);
		}
		reader.close();
	}
}
