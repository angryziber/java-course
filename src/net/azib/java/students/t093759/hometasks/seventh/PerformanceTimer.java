package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;

/**
 * @author dionis
 *         4/7/11 12:18 PM
 */
public class PerformanceTimer {
	private static long measure(Runnable r) {
		long start = System.currentTimeMillis();
		r.run();
		return System.currentTimeMillis() - start;
	}

	public static void main(String[] args) throws IOException {
		final SimpleCopyProgram simpleCopyProgram = new SimpleCopyProgram();
		final BufferedCopyProgram bufferedCopyProgram = new BufferedCopyProgram();

		System.out.println("Data copy:");

		measureAndDisplay(bufferedCopyProgram, new ByteArrayOutputStream(), 100000);
		measureAndDisplay(simpleCopyProgram, new ByteArrayOutputStream(), 100000);

		System.out.println("File copy:");
		measureAndDisplay(bufferedCopyProgram, new File("build.xml"));
		measureAndDisplay(simpleCopyProgram, new File("build.xml"));

	}

	private static void measureAndDisplay(final FileAndDataCopier copyProgram, final OutputStream outputStream, final int countOfBytes) {
		long executionTime;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					copyProgram.copy(new ByteArrayInputStream(new byte[countOfBytes]), outputStream);
				} catch (IOException e) {
					System.err.println(copyProgram.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		};
		executionTime = measure(r);
		System.out.printf("%-20s: %d ms", copyProgram.getClass().getSimpleName(),executionTime);
		System.out.println();
	}

	private static void measureAndDisplay(final FileAndDataCopier copyProgram, final File src) throws IOException {
		long executionTime;
		final File destTempFile;
		destTempFile = File.createTempFile("destTempFile", null);
		destTempFile.deleteOnExit();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					copyProgram.copy(src, destTempFile);
				} catch (IOException e) {
					System.err.println(copyProgram.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		};
		executionTime = measure(r);
		System.out.printf("%-20s: %d ms", copyProgram.getClass().getSimpleName(),executionTime);
		System.out.println();
	}
}
