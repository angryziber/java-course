package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;

/**
 * @author dionis
 *         4/7/11 9:00 AM
 */
public class SimpleCopyProgram implements FileAndDataCopier {
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		if (src == null || dest == null) {
			throw new IllegalArgumentException();
		}
		int oneByteAsInt;
		while ((oneByteAsInt = src.read()) != -1) {
			dest.write(oneByteAsInt);
		}
		dest.flush();
	}

	@Override
	public void copy(File src, File dest) throws IOException {
		if (src == null || dest == null) {
			throw new IllegalArgumentException();
		}
		Reader reader = new FileReader(src);
		Writer writer = new FileWriter(dest);
		int oneByteAsInt;
		while ((oneByteAsInt = reader.read()) != -1) {
			writer.write(oneByteAsInt);
		}
		writer.close();
		reader.close();
	}
}
