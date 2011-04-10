package net.azib.java.students.t110013.hometask7;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * @author Vadim
 */
public class SimpleCopyProgram implements DataCopier, FileCopier {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		int dataByte;
		while ((dataByte = src.read()) != -1) {
			dest.write(dataByte);
		}
		dest.flush();
	}

	@Override
	public void copy(File src, File dest) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			copy(in, out);
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
		}
	}
}
