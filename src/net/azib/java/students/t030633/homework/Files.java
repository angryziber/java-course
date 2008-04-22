package net.azib.java.students.t030633.homework;

import java.io.File;
import java.io.IOException;

/**
 * Holds and handles all input and output files.
 * 
 * @author t030633
 */
public class Files {

	private static String XML_OUTPUT = "athletes.out.xml";
	private static String CSV_INPUT = "athletes.in.csv";
	private static File xmlOutput = new File(XML_OUTPUT);
	private static File csvInput = new File(CSV_INPUT);

	public File getXMLOutputFile() {
		try {
			if (!xmlOutput.createNewFile()) {
				new File(XML_OUTPUT + ".old").delete();
				xmlOutput.renameTo(new File(XML_OUTPUT + ".old"));
				xmlOutput = new File(XML_OUTPUT);
				xmlOutput.createNewFile();
			}
		}
		catch (IOException e) {
			throw new RuntimeException("XML output file error.", e);
		}
		return xmlOutput;
	}

	public File getCSVInputFile() {
		return csvInput;
	}

}
