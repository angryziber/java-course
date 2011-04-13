package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;
import net.azib.java.lessons.io.FileDownloader;

import java.io.*;
import java.net.URL;

/**
 * @author Eduard Shustrov
 */
public abstract class AbstractCopyProgram implements DataCopier, FileCopier, FileDownloader {
	@Override
	public void copy(final File sourceFile, final File destinationFile) throws IOException {
		final InputStream sourceStream = new FileInputStream(sourceFile);
		final OutputStream destinationStream = new FileOutputStream(destinationFile);
		copyAndClose(sourceStream, destinationStream);
	}

	@Override
	public void download(final URL url, final File destinationFolder) throws IOException {
		final InputStream sourceStream = url.openStream();
		final String fileName = url.getPath().replaceAll(".*/", "");
		final OutputStream destinationStream = new FileOutputStream(new File(destinationFolder, fileName));
		copyAndClose(sourceStream, destinationStream);
	}

	private void copyAndClose(InputStream sourceStream, OutputStream destinationStream) throws IOException {
		try {
			copy(sourceStream, destinationStream);
		} finally {
			sourceStream.close();
			destinationStream.close();
		}
	}
}
