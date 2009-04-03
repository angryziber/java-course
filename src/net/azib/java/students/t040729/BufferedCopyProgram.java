package net.azib.java.students.t040729;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 * 
 * @author ValleTon
 */
public class BufferedCopyProgram {
	public static void main(String[] args) throws Exception {

		InputStream kopeeritav = new BufferedInputStream(new FileInputStream("c:\\test.rar"));
		OutputStream teine = new BufferedOutputStream(new FileOutputStream("c:\\test2.rar"));
		long t = System.currentTimeMillis();
		SimpleCopyProgram.copy(kopeeritav, teine);
		kopeeritav.close();
		teine.close();
		System.out.println("Aega võttis: " + (System.currentTimeMillis() - t) + "ms");
	}
}
