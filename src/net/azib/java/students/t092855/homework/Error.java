package net.azib.java.students.t092855.homework;

/**
 * Error enumeration.
 * Contains errors and error messages for Decathlon Calculator.
 *
 * @author t092855
 */
public enum Error {
	ERROR_NUMBER_FORMAT ("Error: number format is wrong."),
	ERROR_FILE_NOT_FOUND ("Error: file not found."),
	ERROR_FILE_WRONG_ENCODING("Error: file wrong encoding. Must be UTF-8 without BOM."),
	ERROR_FILE_CLOSING_FAILED("Error: file closing failed."),
	ERROR_FILE_READ("Error: file reading failed."),
	ERROR_CSV_READ_LINE_FAILED("Error: CSV data reading failed."),
	ERROR_RESULT_MISSING("Error: CSV data error, probable cause: result missing."),
	ERROR_OUT_FILE_NO_NAME("Error: output file name is empty."),
	ERROR_CSV_FILE("Error: can't create output file."),
	ERROR_CSV_FILE_WRITE("Error: can't write to output file."),
	ERROR_DB_PROPERTIES_FILE_NOT_FOUND("Error: database properties file not found."),
	ERROR_DB_PROPERTIES_READ("Error: can't read from database properties file."),
	ERROR_DB_FILE_CLOSE("Error: database file close failed."),
	ERROR_DB_CONNECTION("Error: can't access database."),
	ERROR_DB_CLOSE("Error: can't close database."),
	ERROR_DB_ATHLETE_NOT_FOUND("Error: can't find specified athlete in database."),
	ERROR_DB_ATHLETE_PARSING_FAILED("Error: athlete parsing failed from database."),
	ERROR_DB_ATHLETE_RESULTS_PARSING_FAILED("Error: athlete results parsing failed from database."),
	ERROR_XML_CREATION_FAILED("Error: XML creation failed."),
	ERROR_HTML_CREATION_FAILED("Error: HTML creation failed."),
	ERROR_XSL_CLOSING_FAILED("Error: XSL file closing failed.");

	private final String errorText;

	Error(String s) {
		this.errorText = s;
	}

	/**
	 * Gets error text
	 * @return error text
	 */
	public String getErrorText() {
		return errorText;
	}
}
