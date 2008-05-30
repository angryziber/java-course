package net.azib.java.students.t001370.homework;

/**
 * Errors
 * Enum for holding possible errors 
 * @author maksim
 */
public enum Errors {
	ERROR_COULD_NOT_CREATE_HTML				("Error! Could not create HTML file."),
	ERROR_COULD_NOT_CLOSE_STYLESHEET		("Error! Could not close stylesheet."),
	ERROR_COULD_NOT_WRITE_DATA_TO			("Error! Could not write data to: "),
	ERROR_COULD_NOT_WRITE_TO_XML			("Error! Could not write to XML file."),
	ERROR_PROBLEMS_CLOSING_FILE 			("Error! Problems closing file: "),
	ERROR_PROBLEMS_READING_CSV 				("Error! Problems reading CSV file='"),
	ERROR_OUTPUT_METHOD_NOT_VALID 			("Error! Ouput method is not valid."),
	ERROR_MAJOR_ERROR 						("Error! Major error! Some unresolved errors occured during data processing!"),
	ERROR_CHECK_INPUT_ARG 					("Error! Please check input argument: Input="),
	ERROR_CHECK_OUTPUT_ARG 					("Error! Please check output argument: Output="),
	ERROR_COULD_NOT_GET_DATA_FROM_INPUT 	("Error! Could not get competition results from input."),
	ERROR_COULD_NOT_READ_DB 				("Error! Cound not read from DB."),
	ERROR_COULD_NOT_CLOSE_DB_RELATIONS 		("Error! Cound not close all DB relations."),
	ERROR_NUMBER_FORMAT_IS_WRONG 			("Error! Number format is wrong. Try again."),
	ERROR_FORMAT_IS_WRONG 					("Error! Date format is frong. Try again."),
	ERROR_BIRTHDAY_FORMAT_WRONG_IN_CSV		("Error! Birthday format is wrong in CSV file. Check athlete: "),
	ERROR_ATHLETE_DATA_NOT_VALID_IN_CSV 	("Error! Athlete data in CSV not valid at line='"),
	ERROR_COULD_NOT_GET_DATA_FROM_CSV 		("Error! Could not get data from CSV file."),
	ERROR_PROBLEMS_CLOSING_CSV 				("Error! Problems closing CSV file."),
	ERROR_INPUT_METHOD_NOT_VALID 			("Error! Input method is not valid: "),
	ERROR_RESULT_NUMBER_FORMAT_IS_WRONG 	("Error! Ahtlete result number format is wrong. Result will be set to '0.0'"),
	ERROR_COUNTRY_CONE_DOES_NOT_MATCH 		("Error! Country code does not match pattern. Try again."),
	ERROR_DB_PROPERTIES_NOT_FOUND 			("Error! db.properties file not found."),
	ERROR_PROBLEMS_READING_DB_PROPERTIES 	("Error! IO error reading db.priperties."),
	ERROR_NO_INPUT_ARG_PARAM_FOUND 			("Error! No input argument parameter found."),
	ERROR_NO_OUTPUT_ARG_PARAM_FOUND 		("Error! No output argument parameter found."),
	ERROR_I_OR_O_METHOD_NOT_SET 			("Error! Input or output method is not set."),
	ERROR_IO_ARGS_NOT_SET 					("Error! InputOutput arguments are not set correctly."),
	ERROR_WHILE_PROCESSING_DATA				("Error! Errors occured while processing data.");
	
	
	private String errorText;
	
	/**
	 * Errors constructor
	 * @param error - error description
	 */
	Errors(String error){
		this.errorText = error;
	}

	/**
	 * Get error description
	 * @return error description string
	 */
	public String getErrorText(){
		return this.errorText;
	}
}
