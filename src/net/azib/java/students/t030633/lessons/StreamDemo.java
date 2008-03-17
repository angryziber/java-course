package net.azib.java.students.t030633.lessons;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StreamDemo
 * 
 * @author t030633
 */
public class StreamDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		reader.close();
	}
}
