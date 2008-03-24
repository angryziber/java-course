package net.azib.java.lessons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * AbstractFileCopier
 *
 * @author anton
 */
public abstract class AbstractFileCopier implements FileCopier, DataCopier {

	public void copy(File src, File dest) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		copy(fis, fos);
		// TODO: close
	}

	public abstract void copy(InputStream src, OutputStream dest) throws IOException;

}
