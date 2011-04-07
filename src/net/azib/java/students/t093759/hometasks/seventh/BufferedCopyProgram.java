package net.azib.java.students.t093759.hometasks.seventh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author dionis
 *         4/7/11 9:00 AM
 */
public class BufferedCopyProgram extends SimpleCopyProgram {
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
}
