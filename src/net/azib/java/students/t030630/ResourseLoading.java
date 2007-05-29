package net.azib.java.students.t030630;

import java.io.IOException;
import java.io.InputStream;

public class ResourseLoading {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = ResourseLoading.class.getResourceAsStream("hello.txt");
		int b;
		while ((b = in.read()) != -1){
			System.out.println((char)b);
		}
		in.close();
	}

}
