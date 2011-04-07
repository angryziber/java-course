package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;

public class SimpleBufferedCopyProgram extends SimpleCopyProgram {
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		super.copy(new BufferedInputStream(src), new BufferedOutputStream(dest));
	}
}
