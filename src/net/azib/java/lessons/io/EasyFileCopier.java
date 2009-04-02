package net.azib.java.lessons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * FileCopier implemented using IOUtils
 *
 * @author anton
 */
public class EasyFileCopier implements DataCopier, FileCopier {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		IOUtils.copy(src, dest);
	}

	@Override
	public void copy(File src, File dest) throws IOException {		
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);
		
		try {
			copy(in, out);
		}
		finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}
