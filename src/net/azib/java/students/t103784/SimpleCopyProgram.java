package net.azib.java.students.t103784;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;
import net.azib.java.lessons.io.FileDownloader;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCopyProgram implements FileCopier, DataCopier, FileDownloader {

	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		int bytes;
		while((bytes = src.read()) != -1 ) dest.write(bytes);
	}

	@Override
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

	@Override
	public void download(URL url, File destDir) throws IOException {

	}
}
