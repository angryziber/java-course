package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class BufferedCopyProgram implements FileCopier, DataCopier {
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		int buf;
		src = new BufferedInputStream(src);
		dest = new BufferedOutputStream(dest);
		while ((buf = src.read()) != -1) dest.write(buf);
	}

	@Override
	public void copy(File src, File dest) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			copy(in,out);
			in.close();
			out.close();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}
}
