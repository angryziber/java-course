package net.azib.java.students.t010687;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoading
 *
 * @author t010687
 */
public class ResourceLoading {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = ResourceLoading.class.getResourceAsStream("hello.txt");
		int b;
		while ((b = in.read()) != -1){
			System.out.print((char) b);
		}
		System.out.println("");

	}

}
