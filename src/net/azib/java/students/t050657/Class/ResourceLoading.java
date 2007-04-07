package net.azib.java.students.t050657.Class;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoading
 *
 * @author t050657
 */
public class ResourceLoading {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		InputStream in = ResourceLoading.class.getResourceAsStream("Hello.txt");
		int b;
		while((b = in.read()) != -1) {
			System.out.print((char) b);
		}
		in.close();
		
	}
}
