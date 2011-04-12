package net.azib.java.students.t110013.hometask8;

import net.azib.java.lessons.io.FileDownloader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;

/**
 * @author Vadim
 */
public class ApacheCommonsPoweredFileDownloaderImpl implements FileDownloader {

	@Override
	public void download(URL url, File destDir) throws IOException {
		String fileName = FilenameUtils.getName(url.getPath());
		FileUtils.copyURLToFile(url, new File(destDir, fileName));
				// For some reason there is no method with timeouts in IDEA's apache commons FileUtils
	}
}
