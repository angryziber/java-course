package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Eduard Shustrov
 */
public class SimpleCopyProgram extends AbstractCopyProgram implements DataCopier, FileCopier {
	@Override
	protected void specificCopy(InputStream sourceStream, OutputStream destinationStream) throws IOException {
		int dataByte;
		while ((dataByte = sourceStream.read()) != -1) destinationStream.write(dataByte);
	}
}
