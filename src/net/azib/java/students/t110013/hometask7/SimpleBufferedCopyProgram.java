package net.azib.java.students.t110013.hometask7;

import java.io.*;

/**
 * @author Vadim
 */
public class SimpleBufferedCopyProgram extends SimpleCopyProgram {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		super.copy(new BufferedInputStream(src), new BufferedOutputStream(dest));
	}
}
