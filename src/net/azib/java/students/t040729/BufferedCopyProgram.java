package net.azib.java.students.t040729;

import net.azib.java.lessons.io.DataCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 * 
 * @author ValleTon
 */
public class BufferedCopyProgram extends SimpleCopyProgram {
	
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		super.copy(new BufferedInputStream(src), new BufferedOutputStream(dest));
	}

	public static void main(String[] args) throws Exception {
		InputStream kopeeritav = new FileInputStream("c:\\test.rar");
		OutputStream teine = new FileOutputStream("c:\\test2.rar");
		DataCopier scp = new BufferedCopyProgram();
		long t = System.currentTimeMillis();
		scp.copy(kopeeritav, teine);
		kopeeritav.close();
		teine.close();
		System.out.println("Aega võttis: " + (System.currentTimeMillis() - t) + "ms");
	}
}
