package net.azib.java.students.t030633.hometasks.copier;

import net.azib.java.lessons.io.FileCopier;
import net.azib.java.students.t030633.hometasks.FileLocations;

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

	public CopyPerformanceTimer() {
		this(FileLocations.SOURCE_FILE, FileLocations.DESTINATION_FILE);
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
		System.out.println(new CopyPerformanceTimer().measureCopyTime(new ChanneledCopyProgram()));
		System.out.println(new CopyPerformanceTimer().measureCopyTime(new DirectChanneledCopyProgram()));
	}

}
