package net.azib.java.students.t030633;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * CopyPerformanceTimer
 * 
 * @author t030633
 */
public class CopyPerformanceTimer {

	static File SOURCE_FILE;
	static File DEST_FILE;

	static {
		try {
			/*
			 * SDN bug 4466485. Synopsis: getClass().getResource().getFile()
			 * returns file name with %20. Work around : you can force any
			 * %-escaped characters to be decoded by first converting the URL to
			 * a URI, and then using the path component of the URI as the
			 * filename.
			 */
			URI sourceURI = new URI(CopyPerformanceTimer.class.getClassLoader().getResource("java-logo.gif").toString());
			SOURCE_FILE = new File(sourceURI.getPath());
			DEST_FILE = File.createTempFile("copydest", ".gif");
		}
		catch (Exception e) {
			DEST_FILE = null;
		}
	}

	private final File source;
	private final File destination;

	public CopyPerformanceTimer() {
		this(SOURCE_FILE, DEST_FILE);
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
