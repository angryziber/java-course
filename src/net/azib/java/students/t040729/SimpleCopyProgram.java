package net.azib.java.students.t040729;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * SimpleCopyProgram
 * 
 * @author ValleTon
 * 
 *         Had problem with static main method which cannot use non-static
 *         methods, so temporarily made copy to static.
 */

// public class SimpleCopyProgram implements FileCopier, DataCopier{
public class SimpleCopyProgram {

	// @Override
	public static void copy(InputStream src, OutputStream dest) throws IOException {
		int b;
		while ((b = src.read()) != -1) {
			dest.write(b);
		}

	}

	// @Override
	public static void copy(File src, File dest) throws IOException {
		InputStream fileIn = new FileInputStream(src);
		OutputStream fileOut = new FileOutputStream(dest);
		copy(fileIn, fileOut);
	}

	public static void main(String[] args) throws Exception {

		FileInputStream kopeeritav = new FileInputStream("c:\\test.rar");
		FileOutputStream teine = new FileOutputStream("c:\\test2.rar");

		try {
			long t = System.currentTimeMillis();
			copy(kopeeritav, teine);
			System.out.println("Aega võttis: " + (System.currentTimeMillis() - t) + "ms");
		}
		catch (IOException e) {
			System.out.println("Jama juhtus.");
		}
		finally {
			kopeeritav.close();
			teine.close();
		}
	}
}
