package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * AbstractCopier
 *
 * @author romi
 */
public abstract class AbstractCopier implements FileCopier, DataCopier {

	public void copy(File src, File dest) throws IOException {
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		copy(is, os);
		is.close();
		os.close();
	}

	public abstract void copy(InputStream src, OutputStream dest) throws IOException;

}
