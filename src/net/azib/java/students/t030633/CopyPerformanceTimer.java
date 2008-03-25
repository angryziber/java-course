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

	static final String SEP = System.getProperty("file.separator");
	static File SOURCE_FILE;
	static File DEST_FILE;

	static {
		try {
			/*
			 * SDN bug 4466485.
			 * 
			 * Synopsis: getClass().getResource().getFile() returns file name
			 * with %20.
			 * 
			 * Work around : you can force any %-escaped characters to be
			 * decoded by first converting the URL to a URI, and then using the
			 * path component of the URI as the filename.
			 */
			URI source = new URI(CopyPerformanceTimer.class.getClassLoader().getResource(
					"net" + SEP + "azib" + SEP + "java" + SEP + "students" + SEP + "t030633" + SEP + "timer.testfile.htm")
					.toString());
			SOURCE_FILE = new File(source.getPath());
			DEST_FILE = File.createTempFile("timer.destfile", ".htm");
		}
		catch (Exception e) {
			System.err.println("File initialization error.");
		}
		finally {
			if (DEST_FILE != null)
				DEST_FILE.deleteOnExit();
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
