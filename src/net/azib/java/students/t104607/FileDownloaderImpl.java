package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.io.FileDownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloaderImpl extends BufferedCopyProgram implements FileDownloader {
	@Override
	public void download(URL url, File destDir) throws IOException {
		copy(url.openStream(),new FileOutputStream(destDir.getAbsolutePath()+url.getFile()));
	}
}
