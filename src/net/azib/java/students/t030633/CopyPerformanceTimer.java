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

	static final String SOURCE_ADDRESS = "bin" + System.getProperty("file.separator") + "java-logo.gif";
	static final String DESTINATION_ADDRESS = System.getProperty("java.io.tmpdir") + ".copydest.gif";
	private final File source;
	private final File destination;

	public CopyPerformanceTimer() {
		this(new File(SOURCE_ADDRESS), new File(DESTINATION_ADDRESS));
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
