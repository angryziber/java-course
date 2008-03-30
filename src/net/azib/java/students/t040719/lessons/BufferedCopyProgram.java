package net.azib.java.students.t040719.lessons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 *
 * @author romi
 */
public class BufferedCopyProgram extends AbstractFileCopier {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(src);
		BufferedOutputStream bos = new BufferedOutputStream(dest);
		while(bis.available()>0)
			bos.write(bis.read());
		bis.close();
		bos.close();
	}
}
