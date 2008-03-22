package net.azib.java.students.t980814.lec6;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleFileCopier
 *
 * @author dell
 */
public class SimpleFileCopier implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream(src);
			fo = new FileOutputStream(dest);
			int data;
			while((data = fi.read()) != -1)
				fo.write(data);
		}
		catch (IOException e) {
			
		}
		finally {
			if (fi != null)
				fi.close();
			if (fo != null)
				fo.close();
		}
	}
}
