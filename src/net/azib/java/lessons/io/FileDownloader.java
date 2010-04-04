package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * FileDownloader
 *
 * @author anton
 */
public interface FileDownloader {
	/**
	 * Downloads the file content from the specified URL and saves to the provided destination directory.
	 * @param url where file content is downloaded from
	 * @param destDir destination directory, where to save the file. Name of the file is taken from the URL. 
	 * @throws IOException
	 */
	void download(URL url, File destDir) throws IOException;
}
