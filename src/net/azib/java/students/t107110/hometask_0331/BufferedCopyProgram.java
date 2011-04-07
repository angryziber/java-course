package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * @author Eduard Shustrov
 */
public class BufferedCopyProgram extends AbstractCopyProgram implements DataCopier, FileCopier {
	@Override
	protected void specificCopy(InputStream sourceStream, OutputStream destinationStream) throws IOException {
		final InputStream bufferedSourceStream = new BufferedInputStream(sourceStream);
		final OutputStream bufferedDestinationStream = new BufferedOutputStream(destinationStream);

		int dataByte;
		while ((dataByte = bufferedSourceStream.read()) != -1) bufferedDestinationStream.write(dataByte);
		bufferedDestinationStream.flush();
	}
}
