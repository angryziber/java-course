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

	static final File SOURCE_ADDRESS = new File(CopyPerformanceTimer.class.getClassLoader().getResource("java-logo.gif").getPath());
	static File DESTINATION_ADDRESS;
	
	static {
		try {
			DESTINATION_ADDRESS = File.createTempFile("copydest", ".gif");
		}
		catch (IOException e) {
			DESTINATION_ADDRESS = null;
		}
	}
	
	private final File source;
	private final File destination;

	public CopyPerformanceTimer() {
		this(SOURCE_ADDRESS, DESTINATION_ADDRESS);
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
