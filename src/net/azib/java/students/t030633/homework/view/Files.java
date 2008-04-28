package net.azib.java.students.t030633.homework.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

/**
 * Holds and handles all input and output files.
 * 
 * @author t030633
 */
public class Files {

	private static final String INPUT_ERROR = "Input file not found.";
	private static final String OUTPUT_ERROR = "Unable to create output file.";
	private static final String TEMP_ERROR = "Unable to create temporary files.";

	public static String OUTPUT_FILENAME = "athletes.out";
	public static String INPUT_FILENAME = "athletes.in";

	/**
	 * @return File - file for output
	 * @throws FileNotFoundException
	 *             if unable to create the file
	 */
	public File getOutputFile(String extension) throws FileNotFoundException {
		File file = null;
		try {
			URI path = Files.class.getResource("..").toURI();
			file = new File(path.getPath(), File.separatorChar + OUTPUT_FILENAME + "." + extension);
			if (!file.createNewFile()) {
				new File(path.getPath(), File.separatorChar + "old." + OUTPUT_FILENAME + "." + extension).delete();
				file.renameTo(new File(path.getPath(), File.separatorChar + "old." + OUTPUT_FILENAME + "." + extension));
				file = new File(path.getPath(), File.separatorChar + OUTPUT_FILENAME + "." + extension);
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
	public File getInputFile(String extension) throws FileNotFoundException {
		try {
			URI path = Files.class.getResource("..").toURI();
			return new File(path.getPath(), File.separatorChar + INPUT_FILENAME + "." + extension);
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
	public File getTempFile() throws FileNotFoundException {
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
