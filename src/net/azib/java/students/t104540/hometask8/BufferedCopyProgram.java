package net.azib.java.students.t104540.hometask8;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class BufferedCopyProgram implements FileCopier, DataCopier {
	public void copy(InputStream src, OutputStream dest) throws IOException {
		src = new BufferedInputStream(src);
		try{
			int a;
			while((a = src.read()) != -1 ) dest.write((byte)a);

		}finally{
			IOUtils.closeQuietly(src);
			dest.flush();
		}
	}

	public void copy(File src, File dest) throws IOException {
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(dest));
		output.write(input.read());

		// todo: copy the whole file, close the files
	}
}
