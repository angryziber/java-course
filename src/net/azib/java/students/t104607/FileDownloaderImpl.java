package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.io.FileDownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloaderImpl implements FileDownloader {
	@Override
	public void download(URL url, File destDir) throws IOException {
		BufferedCopyProgram bufferedCopyProgram = new BufferedCopyProgram();
		bufferedCopyProgram.copy(url.openStream(),new FileOutputStream(destDir.getAbsolutePath()+url.getFile()));
	}

	public static void main(String[] args) {
		FileDownloaderImpl fd = new FileDownloaderImpl();
		try {
			URL url = new URL("http://www.google.ee/index.html");
			String tempDir = System.getProperty("java.io.tmpdir");
			fd.download(url,new File(tempDir));
			File testFile = new File(tempDir + url.getFile());
			testFile.deleteOnExit();
			System.out.println("Downloaded file: " + testFile.getAbsolutePath());
			System.out.println("Downloaded file size: " + testFile.length() + " byte");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
