package net.azib.java.students.t093759.hometasks.seventh;

import java.io.*;

/**
 * @author dionis
 *         4/7/11 12:18 PM
 */
public class PerformanceTimer {
	private static PrintWriter out = new PrintWriter(System.out, true);
	private static PrintWriter err = new PrintWriter(System.err, true);
	private static final File FILE = new File("lib/antlr.jar");


	private static long measure(Runnable r) {
		long start = System.currentTimeMillis();
		r.run();
		return System.currentTimeMillis() - start;
	}

	public static void main(String[] args) throws IOException {
		SimpleCopyProgram simpleCopyProgram = new SimpleCopyProgram();
		BufferedCopyProgram bufferedCopyProgram = new BufferedCopyProgram();
		SimpleBufferedCopyProgram simpleBufferedCopyProgram = new SimpleBufferedCopyProgram();

		out.println("Data copy:");

		measureAndDisplay(bufferedCopyProgram, new ByteArrayOutputStream(), 100000);
		measureAndDisplay(simpleCopyProgram, new ByteArrayOutputStream(), 100000);

		out.println("File copy:");
		measureAndDisplay(bufferedCopyProgram, FILE);
		measureAndDisplay(simpleCopyProgram, FILE);
		measureAndDisplay(simpleBufferedCopyProgram, FILE);
	}

	private static void measureAndDisplay(final FileAndDataCopier copyProgram, final OutputStream outputStream, final int countOfBytes) {
		long executionTime = measure(new Runnable() {
			@Override
			public void run() {
				try {
					copyProgram.copy(new ByteArrayInputStream(new byte[countOfBytes]), outputStream);
				} catch (IOException e) {
					err.println(copyProgram.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		});
		out.printf("%-20s: %d ms", copyProgram.getClass().getSimpleName(), executionTime);
		out.println();
	}

	private static void measureAndDisplay(final FileAndDataCopier copyProgram, final File src) throws IOException {

		final File destTempFile;
		destTempFile = File.createTempFile("destTempFile", null);
		destTempFile.deleteOnExit();
		long executionTime = measure(new Runnable() {
			@Override
			public void run() {
				try {
					copyProgram.copy(src, destTempFile);
				} catch (IOException e) {
					err.println(copyProgram.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		});
		out.printf("%-20s: %d ms", copyProgram.getClass().getSimpleName(), executionTime);
		out.println();
	}
}
