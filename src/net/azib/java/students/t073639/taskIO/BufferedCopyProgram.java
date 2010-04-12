package net.azib.java.students.t073639.taskIO;

import net.azib.java.lessons.io.FileCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * BufferedCopyProgram
 * 
 * @author t073639
 */
public class BufferedCopyProgram implements FileCopier {

	@Override
	public void copy(File src, File dest) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);
		int size = 4000;
		BufferedInputStream inStream = new BufferedInputStream(in, size);
		BufferedOutputStream outStream = new BufferedOutputStream(out, size);
		try {

			byte[] b = new byte[size];
			long s = src.length();
			while (inStream.read(b, 0, size) != -1) {
				outStream.write(b, 0, size);
				s = s - size;
				if (s < size && s > 0)
					size = (int) s;
			}
		}
		catch (IOException e) {
			System.err.println("Error");
		}
		finally {
			IOUtils.closeQuietly(inStream);
			IOUtils.closeQuietly(outStream);
		}
	}

}
