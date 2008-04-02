package net.azib.java.students.t030633.hometasks.copier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 * 
 * @author t030633
 */
public class BufferedCopyProgram extends AbstractFileCopier {

	public void copy(InputStream src, OutputStream dest) throws IOException {
		BufferedInputStream in = new BufferedInputStream(src);
		BufferedOutputStream out = new BufferedOutputStream(dest);
		while (in.available() > 0)
			out.write(in.read());
		out.flush();
	}

}
