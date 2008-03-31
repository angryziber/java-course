package net.azib.java.students.t040719.lessons;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * SimpleCopyProgram
 *
 * @author romi
 */
public class SimpleCopyProgram extends AbstractCopier {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		while (src.available()>0)
			dest.write(src.read());
	}
}
