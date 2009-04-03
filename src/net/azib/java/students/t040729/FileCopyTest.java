package net.azib.java.students.t040729;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileCopyTest
 *
 * @author ValleTon
 */
public class FileCopyTest {

	public static void main(String[] args) throws Exception {
		FileInputStream kopeeritav = new FileInputStream("c:\\test.rar");
		FileOutputStream teine = new FileOutputStream("c:\\test2.rar");
		SimpleCopyProgram scp = new SimpleCopyProgram();
		
		try {
			long t = System.currentTimeMillis();
			scp.copy(kopeeritav, teine);
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
