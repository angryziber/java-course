package net.azib.java.students.t980814.lec6;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedFileCopier
 *
 * @author dell
 */
public class BufferedFileCopier implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			byte data[] = new byte[1024];
			int nofBytes;
			fi = new FileInputStream(src);
			fo = new FileOutputStream(dest);
			while((nofBytes = fi.read(data)) != -1)
				fo.write(data, 0, nofBytes);
		}
		finally {
			if (fi != null)
				fi.close();
			if (fo != null)
				fo.close();
		}
	}
}
