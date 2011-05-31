package net.azib.java.students.t092855.homework;

/**
 * Error enumeration.
 * Contains errors and error messages for Decathlon Calculator.
 *
 * @author t092855
 */
public enum Error {
	ERROR_NUMBER_FORMAT ("number format is wrong."),
	ERROR_FILE_NOT_FOUND ("file not found."),
	ERROR_FILE_WRONG_ENCODING("file wrong encoding. Must be UTF-8 without BOM."),
	ERROR_FILE_CLOSING_FAILED("file closing failed."),
	ERROR_FILE_READ("file reading failed."),
	ERROR_CSV_READ_LINE_FAILED("CSV data reading failed."),
	ERROR_RESULT_MISSING("CSV data error, probable cause: result missing."),
	ERROR_OUT_FILE_NO_NAME("output file name is empty."),
	ERROR_CSV_FILE("can't create output file."),
	ERROR_CSV_FILE_WRITE("can't write to output file."),
	ERROR_DB_PROPERTIES_FILE_NOT_FOUND("database properties file not found."),
	ERROR_DB_PROPERTIES_READ("can't read from database properties file."),
	ERROR_DB_FILE_CLOSE("database file close failed."),
	ERROR_DB_CONNECTION("can't access database."),
	ERROR_DB_CLOSE("can't close database."),
	ERROR_DB_ATHLETE_NOT_FOUND("can't find specified athlete in database."),
	ERROR_DB_ATHLETE_PARSING_FAILED("athlete parsing failed from database."),
	ERROR_DB_ATHLETE_RESULTS_PARSING_FAILED("athlete results parsing failed from database."),
	ERROR_XML_CREATION_FAILED("XML creation failed."),
	ERROR_HTML_CREATION_FAILED("HTML creation failed."),
	ERROR_XSL_CLOSING_FAILED("XSL file closing failed."),
	ERROR_INPUT_PARAMETERS_INCORRECT("input parameters are incorrect."),
	ERROR_OUTPUT_PARAMETERS_INCORRECT("output parameters are incorrect."),
	ERROR_IO_PARAMETERS_INCORRECT("input/output parameters are incorrect.");

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
