package net.azib.java.students.t073857.hw7;

import net.azib.java.lessons.io.FileDownloader;
import net.azib.java.students.t073857.hw6.BufferedCopyProgram;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * FileDownloaderImpl
 *
 * @author Joonas Vali
 */
public class FileDownloaderImpl extends BufferedCopyProgram implements FileDownloader{	
	@Override
	public void download(URL url, File destDir) throws IOException {		
		copy(url.openStream(), new FileOutputStream(new File(destDir, url.getFile())));		
	}
}
