package net.azib.java.students.t030633.hometasks;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * TestFileLocations
 * 
 * @author t030633
 */
public class FileLocations {

//	static final String SEP = System.getProperty("file.separator");
	public static File SOURCE_FILE;
	public static File DESTINATION_FILE;
	
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
			URI source = FileLocations.class.getResource("testfile.htm").toURI();
			SOURCE_FILE = new File(source.getPath());
		}
		catch (Exception e) {
			System.err.println("Source file initialization error.");
		}
		
		try {
			DESTINATION_FILE = File.createTempFile("destfile", ".htm");
		}
		catch (IOException e) {
			System.err.println("Destination file initialization error.");
		}
		finally {
			if (DESTINATION_FILE != null)
				DESTINATION_FILE.deleteOnExit();
		}
		
	}
	
}
