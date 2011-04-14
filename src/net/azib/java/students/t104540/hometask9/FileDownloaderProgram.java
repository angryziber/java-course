package net.azib.java.students.t104540.hometask9;

import net.azib.java.lessons.io.FileDownloader;
import net.azib.java.students.t104540.hometask8.BufferedCopyProgram;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;

public class FileDownloaderProgram implements FileDownloader{
	@Override
	public void download(URL url, File destDir) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(destDir);

		BufferedCopyProgram bufferedCopyProgram = new BufferedCopyProgram();
		bufferedCopyProgram.copy(url.openStream(), fileOutputStream);

	}
}
