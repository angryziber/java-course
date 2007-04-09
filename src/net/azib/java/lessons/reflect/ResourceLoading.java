package net.azib.java.lessons.reflect;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoading
 *
 * @author anton
 */
public class ResourceLoading {
	public static void main(String[] args) throws IOException {
		InputStream in = ResourceLoading.class.getResourceAsStream("hello.txt");
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char)b);
		}
		in.close();
	}
}
