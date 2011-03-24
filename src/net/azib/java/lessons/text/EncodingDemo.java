package net.azib.java.lessons.text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "õluф";

		byte[] encoded1 = s.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(encoded1));
		System.out.println(new String(encoded1, "ISO-8859-1"));

		byte[] encoded5 = s.getBytes("ISO-8859-5");
		System.out.println(Arrays.toString(encoded5));
		System.out.println(new String(encoded5, "ISO-8859-5"));
		System.out.println(new String(encoded1, "ISO-8859-5"));

		byte[] encodedUtf = s.getBytes("UTF-8");
		System.out.println(Arrays.toString(encodedUtf));
		System.out.println(new String(encodedUtf, "ISO-8859-1"));
		System.out.println(new String(encoded1, "UTF-8"));

		System.out.println("\uD834\uDD1E".length());
	}
}
