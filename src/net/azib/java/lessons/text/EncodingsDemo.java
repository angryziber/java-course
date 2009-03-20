package net.azib.java.lessons.text;

import java.io.UnsupportedEncodingException;

/**
 * EncodingsDemo
 *
 * @author anton
 */
public class EncodingsDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ABCÄÖЙФÑⴲ갊";
		System.out.println(s);
		
		byte[] bytesInDefaultEncoding = s.getBytes();
		System.out.println(s.length() + " vs " + bytesInDefaultEncoding.length);
		
		byte[] bytesInLatin1 = s.getBytes("ISO-8859-1");
		byte[] bytesInWin1251 = s.getBytes("Windows-1251");
		byte[] bytesInUtf8 = s.getBytes("UTF-8");
		System.out.println("In Latin1: " + bytesInLatin1.length + ": " + new String(bytesInLatin1, "ISO-8859-1"));
		System.out.println("In Win1251: " + bytesInWin1251.length + ": " + new String(bytesInWin1251, "Windows-1251"));
		System.out.println("In UTF-8: " + bytesInUtf8.length + ": " + new String(bytesInUtf8, "UTF-8"));
	}
}
