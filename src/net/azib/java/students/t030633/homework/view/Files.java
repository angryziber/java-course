package net.azib.java.students.t030633.homework.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Holds and handles all input and output files.
 * 
 * @author t030633
 */
public class Files {

	private static final String INPUT_ERROR = "Input file not found.";
	private static final String OUTPUT_ERROR = "Unable to create output file.";
	private static final String TEMP_ERROR = "Unable to create temporary files.";

	private static URI output;
	private static URI input;

	public static void setOutput(String name) throws URISyntaxException {
		output = new URI(name);
	}
	
	public static void setInput(String name) throws URISyntaxException {
		input = new URI(name);
	}
	
	/**
	 * @return File - file for output
	 * @throws FileNotFoundException
	 *             if unable to create the file
	 */
	public static File getOutputFile() throws FileNotFoundException {
		File file = null;
		try {
			URI path = Files.class.getResource("..").toURI();
			file = new File(path.getPath(), output.getPath());
			if (!file.createNewFile()) {
				new File(path.getPath(), output.getPath() + ".old").delete();
				file.renameTo(new File(path.getPath(), output + ".old"));
				file = new File(path.getPath(), output.getPath());
				file.createNewFile();
			}
		}
		catch (Exception e) {
			throw new FileNotFoundException(OUTPUT_ERROR);
		}
		return file;
	}

	/**
	 * @return File - file for input
	 * @throws FileNotFoundException
	 *             if unable to open the file
	 */
	public static File getInputFile() throws FileNotFoundException {
		try {
			URI path = Files.class.getResource("..").toURI();
			return new File(path.getPath(), input.getPath());
		}
		catch (Exception e) {
			throw new FileNotFoundException(INPUT_ERROR);
		}
	}

	/**
	 * @return File - temporary file
	 * @throws FileNotFoundException
	 *             if unable to create a temporary file
	 */
	public static File getTempFile() throws FileNotFoundException {
		File temp = null;
		try {
			temp = File.createTempFile("athletes", ".tmp");
			return temp;
		}
		catch (IOException e) {
			throw new FileNotFoundException(TEMP_ERROR);
		}
		finally {
			if (temp != null)
				temp.deleteOnExit();
		}
	}
	
}
