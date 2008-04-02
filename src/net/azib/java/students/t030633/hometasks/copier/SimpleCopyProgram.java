package net.azib.java.students.t030633.hometasks.copier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * SimpleCopyProgram
 * 
 * @author t030633
 */
public class SimpleCopyProgram extends AbstractFileCopier {

	public void copy(InputStream src, OutputStream dest) throws IOException {
		while (src.available() > 0)
			dest.write(src.read());
	}

}
