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
 */

public class SimpleCopyProgram implements FileCopier, DataCopier{
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		int b;
		while ((b = src.read()) != -1) {
			dest.write(b);
		}
	}

	@Override
	public void copy(File src, File dest) throws IOException {
		InputStream fileIn = new FileInputStream(src);
		OutputStream fileOut = new FileOutputStream(dest);
		copy(fileIn, fileOut);
	}
}
