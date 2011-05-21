package net.azib.java.students.t092855.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ErrorTest
 *
 * @author t092855
 */
public class ErrorTest {
	@Test
	public void errorTextsAreCorrect() {
		assertEquals("Error: number format is wrong.", Error.ERROR_NUMBER_FORMAT.getErrorText());
		assertEquals("Error: file not found.", Error.ERROR_FILE_NOT_FOUND.getErrorText());
		assertEquals("Error: file wrong encoding. Must be UTF-8 without BOM.", Error.ERROR_FILE_WRONG_ENCODING.getErrorText());
		assertEquals("Error: file closing failed.", Error.ERROR_FILE_CLOSING_FAILED.getErrorText());
		assertEquals("Error: file reading failed.", Error.ERROR_FILE_READ.getErrorText());
		assertEquals("Error: CSV data reading failed.", Error.ERROR_CSV_READ_LINE_FAILED.getErrorText());
		assertEquals("Error: CSV data error, probable cause: result missing.", Error.ERROR_RESULT_MISSING.getErrorText());
		assertEquals("Error: output file name is empty.", Error.ERROR_OUT_FILE_NO_NAME.getErrorText());
		assertEquals("Error: can't create output file.", Error.ERROR_CSV_FILE.getErrorText());
		assertEquals("Error: can't write to output file.", Error.ERROR_CSV_FILE_WRITE.getErrorText());
	}
}
