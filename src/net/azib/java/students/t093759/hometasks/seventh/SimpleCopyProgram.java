package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;

/**
 * @author dionis
 *         4/7/11 9:00 AM
 */
public class SimpleCopyProgram implements FileAndDataCopier {
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		int oneByteAsInt;
		while ((oneByteAsInt = src.read()) != -1) {
			dest.write(oneByteAsInt);
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
		}
		finally {
			if (in != null) in.close();
			if (out != null) out.close();
		}
	}
}
