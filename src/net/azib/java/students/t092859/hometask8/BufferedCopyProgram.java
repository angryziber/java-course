package net.azib.java.students.t092859.hometask8;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;
import net.azib.java.lessons.io.FileDownloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * BufferedCopyProgram
 *
 * @author kostya
 */
public class BufferedCopyProgram implements FileCopier, DataCopier, FileDownloader{

	
	@Override
	public void copy(File src, File dest) throws IOException {
		InputStream input = new BufferedInputStream(new FileInputStream(src));
		OutputStream output = new BufferedOutputStream(new FileOutputStream(dest));
		
		copy(input, output);
		
		input.close();
		output.close();
	}

	@Override
	public void download(URL url, File destDir) throws IOException {
		URLConnection connection = url.openConnection();
		InputStream urlInput = connection.getInputStream();
		OutputStream fileOutput = new BufferedOutputStream(new FileOutputStream(destDir));
		copy(urlInput, fileOutput);
	}

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		byte[] buffer = new byte[2048];
		int len;
		while((len = src.read(buffer)) != -1)
			dest.write(buffer, 0, len);
	}

}
