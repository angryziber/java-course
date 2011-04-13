package net.azib.java.students.t107110.hometask_0331;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public abstract class AbstractCopyProgramTest {
	private final String copyingMethodName;
	private final AbstractCopyProgram copier;
	private File sourceFile;
	private File destinationFile;

	public AbstractCopyProgramTest(final String copyingMethodName, final AbstractCopyProgram copier) {
		this.copyingMethodName = copyingMethodName;
		this.copier = copier;
	}

	@Before
	public void setup() throws IOException {
		sourceFile = File.createTempFile("t107110source", null);
		sourceFile.deleteOnExit();
		fillFileWithRandomData(sourceFile);

		destinationFile = File.createTempFile("t107110destination", null);
		destinationFile.deleteOnExit();
	}

	@Test
	public void measureCopyingTime() throws IOException {
		final long timeTaken = PerformanceTimer.measureTime(copier, sourceFile, destinationFile);
		checkFileSizeAndShowMeasuredTime("copied", timeTaken);
	}

	@Test
	public void measureDownloadingTime() throws IOException {
		final URL sourceURL = sourceFile.toURI().toURL();
		final File destinationFolder = destinationFile.getParentFile();
		final long timeTaken = PerformanceTimer.measureTime(copier, sourceURL, destinationFolder);
		checkFileSizeAndShowMeasuredTime("downloaded", timeTaken);
	}

	private void fillFileWithRandomData(final File file) throws IOException {
		int byteCount = 256 * 1024;
		final OutputStream stream = new BufferedOutputStream(new FileOutputStream(file));

		final Random random = new Random();
		while (byteCount-- != 0) stream.write(random.nextInt(Byte.MAX_VALUE + 1));
		stream.close();
	}

	private void checkFileSizeAndShowMeasuredTime(final String actionName, final long timeTaken) {
		assertThat(destinationFile.length(), is(equalTo(sourceFile.length())));
		System.out.println(copyingMethodName + " copy program has " + actionName + " a file " +
				"in " + timeTaken + " milliseconds");
	}
}
