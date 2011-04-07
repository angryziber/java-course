package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;
import java.util.Arrays;

/**
 * @author dionis
 *         4/7/11 9:00 AM
 */
public class BufferedCopyProgram implements FileAndDataCopier {
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		if (src == null || dest == null) {
			throw new IllegalArgumentException();
		}
		int countOfBytes;
		byte[] buffer = new byte[512];
		while ((countOfBytes = src.read(buffer)) != -1) {
			dest.write(Arrays.copyOf(buffer, countOfBytes));
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
		int countOfChars;
		char[] buffer = new char[512];
		while ((countOfChars = reader.read(buffer)) != -1) {
			writer.write(Arrays.copyOf(buffer, countOfChars));
		}
		writer.close();
		reader.close();
	}
}
