package net.azib.java.lessons.text;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * CharacterEncodings
 *
 * @author anton
 */
public class CharacterEncodings {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "aäšⲀ丸";
		System.out.println(s.length());
		
		byte[] b = s.getBytes("ISO-8859-13");
		System.out.println(b.length);
		System.out.println(new String(b, "ISO-8859-13"));
		
		b = s.getBytes("UTF-8");
		System.out.println(Arrays.toString(b));
		System.out.println(b.length);
	}
}
