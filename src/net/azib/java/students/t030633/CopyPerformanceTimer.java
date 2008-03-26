package net.azib.java.students.t030633;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * CopyPerformanceTimer
 * 
 * @author t030633
 */
public class CopyPerformanceTimer {

	private final File source;
	private final File destination;
	static File DEST_FILE;

	static {
		try {
			DEST_FILE = File.createTempFile("timer.destfile", ".htm");
		}
		catch (IOException e) {
			System.err.println("File initialization error.");
		}
		finally {
			if (DEST_FILE != null)
				DEST_FILE.deleteOnExit();
		}
	}

	public CopyPerformanceTimer() {
		this(TestFileLocation.SOURCE_FILE, CopyPerformanceTimer.DEST_FILE);
	}

	public CopyPerformanceTimer(File src, File dest) {
		this.source = src;
		this.destination = dest;
	}

	public long measureCopyTime(FileCopier copier) throws IOException {
		long t = System.currentTimeMillis();
		copier.copy(source, destination);
		return System.currentTimeMillis() - t;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new CopyPerformanceTimer().measureCopyTime(new SimpleCopyProgram()));
		System.out.println(new CopyPerformanceTimer().measureCopyTime(new BufferedCopyProgram()));
	}

}
