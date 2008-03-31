package net.azib.java.students.t030633;

import java.io.File;
import java.net.URI;

/**
 * TestFileLocations
 * 
 * @author t030633
 */
public class TestFileLocation {

	static final String SEP = System.getProperty("file.separator");
	static File SOURCE_FILE;
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
			URI source = CopyPerformanceTimer.class.getResource("timer.testfile.htm").toURI();
			SOURCE_FILE = new File(source.getPath());
		}
		catch (Exception e) {
			System.err.println("File initialization error.");
		}
	}

}
