package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.PerformanceTimer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class SimpleCopyProgramTest {
	private final SimpleCopyProgram simpleCopyProgram = new SimpleCopyProgram();
	private File sourceFile;
	private File destinationFile;
	private InputStream sourceStream;
	private OutputStream destinationStream;

	@Before
	public void setup() throws IOException {
		sourceFile = File.createTempFile("t107110source", null);
		destinationFile = File.createTempFile("t107110destination", null);

		sourceFile.deleteOnExit();
		destinationFile.deleteOnExit();

		sourceStream = new FileInputStream(sourceFile);
		destinationStream = new FileOutputStream(destinationFile);
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithNullInputStream() throws IOException {
		simpleCopyProgram.copy(null, destinationStream);
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithNullOutputStream() throws IOException {
		simpleCopyProgram.copy(sourceStream, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithNullSourceFile() throws IOException {
		simpleCopyProgram.copy(null, destinationFile);
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithNullDestinationFile() throws IOException {
		simpleCopyProgram.copy(sourceFile, null);
	}

	@Test
	public void copyFile() throws IOException {
		fillFileWithRandomData(sourceFile);
		simpleCopyProgram.copy(sourceFile, destinationFile);
		assertThat(destinationFile.length(), is(equalTo(sourceFile.length())));
	}

	@Test
	public void measureTime() throws IOException {
		fillFileWithRandomData(sourceFile);
		final long timeTaken = PerformanceTimer.measureTime(simpleCopyProgram, sourceFile, destinationFile);
		System.out.println("simple copy program has copied a file in " + timeTaken + " milliseconds");
	}

	@After
	public void clean() throws IOException {
		sourceStream.close();
		destinationStream.close();
	}

	private void fillFileWithRandomData(final File file) throws IOException {
		int byteCount = 64 * 1024;
		final OutputStream stream = new BufferedOutputStream(new FileOutputStream(file));

		final Random random = new Random();
		while (byteCount-- != 0) stream.write(random.nextInt(Byte.MAX_VALUE + 1));
		stream.close();
	}
}
