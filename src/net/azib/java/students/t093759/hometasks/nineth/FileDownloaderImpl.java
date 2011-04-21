package net.azib.java.students.t093759.hometasks.nineth;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileDownloader;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;

/**
 * @author dionis
 *         4/21/11 12:05 PM
 */
public class FileDownloaderImpl implements FileDownloader{
	//TODO write unit tests
	DataCopier dataCopier;

	public FileDownloaderImpl(DataCopier dataCopier) {
		this.dataCopier = dataCopier;
	}

	@Override
	public void download(URL url, File destDir) throws IOException {
		if(!destDir.isDirectory()) throw new IOException("It should be a directory!");
		File destFile = new File(destDir, FilenameUtils.getName(url.getPath()));
		if(destFile.exists()) throw new IOException("Sorry, you can't overwrite existing file!");
		dataCopier.copy(url.openStream(), new FileOutputStream(destFile));
	}

}
