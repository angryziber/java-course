package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import net.azib.java.students.t001370.homework.Errors;

import org.junit.Test;

/**
 * ErrorsTest
 *
 * @author maksim
 */
public class ErrorsTest {


	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Errors#getErrorText()}.
	 */
	@Test
	public void testGetErrorText() {
		assertEquals("Error! Could not create HTML file.", 
				Errors.ERROR_COULD_NOT_CREATE_HTML.getErrorText());
		assertEquals("Error! Could not close stylesheet.",
				Errors.ERROR_COULD_NOT_CLOSE_STYLESHEET.getErrorText());
		assertEquals("Error! Could not write data to: ",
				Errors.ERROR_COULD_NOT_WRITE_DATA_TO.getErrorText());
		assertEquals("Error! Could not write to XML file.",
				Errors.ERROR_COULD_NOT_WRITE_TO_XML.getErrorText());
		assertEquals("Error! Problems closing file: ",
				Errors.ERROR_PROBLEMS_CLOSING_FILE.getErrorText());
		assertEquals("Error! Problems reading CSV file='",
				Errors.ERROR_PROBLEMS_READING_CSV.getErrorText());
		assertEquals("Error! Ouput method is not valid.",
				Errors.ERROR_OUTPUT_METHOD_NOT_VALID.getErrorText());
		assertEquals("Error! Major error! Some unresolved errors occured during data processing!",
				Errors.ERROR_MAJOR_ERROR.getErrorText());
		assertEquals("Error! Please check input argument: Input=",
				Errors.ERROR_CHECK_INPUT_ARG.getErrorText());
		assertEquals("Error! Please check output argument: Output=",
				Errors.ERROR_CHECK_OUTPUT_ARG.getErrorText());
		assertEquals("Error! Could not get competition results from input.",
				Errors.ERROR_COULD_NOT_GET_DATA_FROM_INPUT.getErrorText());
		assertEquals("Error! Cound not read from DB.",
				Errors.ERROR_COULD_NOT_READ_DB.getErrorText());
		assertEquals("Error! Cound not close all DB relations.",
				Errors.ERROR_COULD_NOT_CLOSE_DB_RELATIONS.getErrorText());
		assertEquals("Error! Number format is wrong. Try again.",
				Errors.ERROR_NUMBER_FORMAT_IS_WRONG.getErrorText());
		assertEquals("Error! Date format is frong. Try again.",
				Errors.ERROR_FORMAT_IS_WRONG.getErrorText());
		assertEquals("Error! Birthday format is wrong in CSV file. Check athlete: ",
				Errors.ERROR_BIRTHDAY_FORMAT_WRONG_IN_CSV.getErrorText());
		assertEquals("Error! Athlete data in CSV not valid at line='",
				Errors.ERROR_ATHLETE_DATA_NOT_VALID_IN_CSV.getErrorText());
		assertEquals("Error! Could not get data from CSV file.",
				Errors.ERROR_COULD_NOT_GET_DATA_FROM_CSV.getErrorText());
		assertEquals("Error! Problems closing CSV file.",
				Errors.ERROR_PROBLEMS_CLOSING_CSV.getErrorText());
		assertEquals("Error! Input method is not valid: ",
				Errors.ERROR_INPUT_METHOD_NOT_VALID.getErrorText());
		assertEquals("Error! Ahtlete result number format is wrong. Result will be set to '0.0'",
				Errors.ERROR_RESULT_NUMBER_FORMAT_IS_WRONG.getErrorText());
		assertEquals("Error! Country code does not match pattern. Try again.",
				Errors.ERROR_COUNTRY_CONE_DOES_NOT_MATCH.getErrorText());
		assertEquals("Error! db.properties file not found.",
				Errors.ERROR_DB_PROPERTIES_NOT_FOUND.getErrorText());
		assertEquals("Error! IO error reading db.priperties.",
				Errors.ERROR_PROBLEMS_READING_DB_PROPERTIES.getErrorText());
		assertEquals("Error! No input argument parameter found.",
				Errors.ERROR_NO_INPUT_ARG_PARAM_FOUND.getErrorText());
		assertEquals("Error! No output argument parameter found.",
				Errors.ERROR_NO_OUTPUT_ARG_PARAM_FOUND.getErrorText());
		assertEquals("Error! Input or output method is not set.",
				Errors.ERROR_I_OR_O_METHOD_NOT_SET.getErrorText());
		assertEquals("Error! InputOutput arguments are not set correctly.",
				Errors.ERROR_IO_ARGS_NOT_SET.getErrorText());

	}

}
