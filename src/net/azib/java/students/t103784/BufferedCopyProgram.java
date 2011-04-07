package net.azib.java.students.t103784;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class BufferedCopyProgram {
	
	public static void copy(InputStream src, OutputStream dest) throws IOException {
		int bytes;
		src = new BufferedInputStream(src);
		dest = new BufferedOutputStream(dest);
		while ((bytes = src.read()) != -1) dest.write(bytes);
	}

	public void copy(File src, File dest) throws IOException {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;

		try{
			inputStream = new FileInputStream(src);
			outputStream = new FileOutputStream(dest);
			copy(inputStream,outputStream);
			inputStream.close();
			outputStream.close();
		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
		}
	}
}
