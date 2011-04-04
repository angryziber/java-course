package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * @author Eduard Shustrov
 */
public class BufferedCopyProgram implements DataCopier, FileCopier {
	@Override
	public void copy(final InputStream sourceStream, final OutputStream destinationStream) throws IOException {
		if (sourceStream == null) throw new IllegalArgumentException("no source stream specified");
		if (destinationStream == null) throw new IllegalArgumentException("no destination stream specified");

		final InputStream bufferedSourceStream = new BufferedInputStream(sourceStream);
		final OutputStream bufferedDestinationStream = new BufferedOutputStream(destinationStream);

		int dataByte;
		while ((dataByte = bufferedSourceStream.read()) != -1) {
			bufferedDestinationStream.write(dataByte);
		}
		bufferedDestinationStream.flush();
	}

	@Override
	public void copy(final File sourceFile, final File destinationFile) throws IOException {
		if (sourceFile == null) throw new IllegalArgumentException("no source file specified");
		if (destinationFile == null) throw new IllegalArgumentException("no destination file specified");

		final InputStream sourceStream = new FileInputStream(sourceFile);
		final OutputStream destinationStream = new FileOutputStream(destinationFile);
		copy(sourceStream, destinationStream);
		sourceStream.close();
		destinationStream.close();
	}
}
