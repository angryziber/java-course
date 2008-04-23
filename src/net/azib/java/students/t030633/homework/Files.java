package net.azib.java.students.t030633.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Holds and handles all input and output files and their possible Exceptions.
 * 
 * @author t030633
 */
public class Files {

	static String XML_OUTPUT_FILENAME = "athletes.out.xml";
	static String CSV_INPUT_FILENAME = "athletes.in.csv";

	public File getXMLOutputFile() throws FileNotFoundException {
		File file = null;
		try {
			URI path = Files.class.getResource("").toURI();
			file = new File(path.getPath(), File.separatorChar + XML_OUTPUT_FILENAME);
			if (!file.createNewFile()) {
				new File(path.getPath(), File.separatorChar + "old." + XML_OUTPUT_FILENAME).delete();
				file.renameTo(new File(path.getPath(), File.separatorChar + "old." + XML_OUTPUT_FILENAME));
				file = new File(path.getPath(), File.separatorChar + XML_OUTPUT_FILENAME);
				file.createNewFile();
			}
		}
		catch (Exception e) {
			System.err.println("XML output file error.");
		}
		if (file == null)
			throw new FileNotFoundException("Unable to create XML output file.");
		else
			return file;
	}

	public File getCSVInputFile() throws FileNotFoundException {
		File file = null;
		try {
			URI uri = Files.class.getResource(CSV_INPUT_FILENAME).toURI();
			file = new File(uri.getPath());
		}
		catch (URISyntaxException e) {
			System.err.println("CSV input file error.");
		}
		if (file == null)
			throw new FileNotFoundException("CSV input file not found.");
		else
			return file;
	}

}
