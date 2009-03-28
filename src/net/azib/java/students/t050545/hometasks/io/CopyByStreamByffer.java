package net.azib.java.students.t050545.hometasks.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * CopyByStreamByffer
 * 
 * @author libricon
 */
public class CopyByStreamByffer implements FileCopier, DataCopier {
	public void copy(File input, File output) throws IOException {
		if (input.exists() == true && input.isFile() == true && input.canRead()) {
			copy(new FileInputStream(input), new FileOutputStream(output));
		}
		else {
			System.out.println("Something wrong with your files !!!");
			System.out.println("exist: " + input.exists());
			System.out.println("file: " + input.isFile());
			System.out.println("canRead: " + input.canRead());
		}
	}

	public void copy(InputStream input, OutputStream output) throws IOException {

		BufferedInputStream bufInput = new BufferedInputStream((InputStream) input);
		BufferedOutputStream bufOutput = new BufferedOutputStream((OutputStream) output);

		byte[] buf = new byte[4096];
		int len;
		while ((len = bufInput.read(buf)) >= 0) {
			bufOutput.write(buf, 0, len);
		}

		bufInput.close();
		bufOutput.close();
	}

}
