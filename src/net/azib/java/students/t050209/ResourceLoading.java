package net.azib.java.students.t050209;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoading
 *
 * @author t050209
 */
public class ResourceLoading {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = ResourceLoading.class.getResourceAsStream("hello.txt");
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char)b);
		}
		in.close();
	}

}
