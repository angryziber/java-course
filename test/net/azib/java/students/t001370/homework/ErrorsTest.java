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
		assertEquals("Error 0001! Could not create HTML file.", 
				Errors.ERROR_0001.getErrorText());
		assertEquals("Error 0002! Could not close stylesheet.",
				Errors.ERROR_0002.getErrorText());
		assertEquals("Error 0003! Could not write data to: ",
				Errors.ERROR_0003.getErrorText());
		assertEquals("Error 0004! Could not write to XML file.",
				Errors.ERROR_0004.getErrorText());
		assertEquals("Error 0005! Problems closing file write",
				Errors.ERROR_0005.getErrorText());
		assertEquals("Error 0006! Problems reading CSV file='",
				Errors.ERROR_0006.getErrorText());
		assertEquals("Error 0007! Ouput method is not valid.",
				Errors.ERROR_0007.getErrorText());
		assertEquals("Error 0008! Major error!",
				Errors.ERROR_0008.getErrorText());
		assertEquals("Error 0009! Please check input argument: Input=",
				Errors.ERROR_0009.getErrorText());
		assertEquals("Error 0010! Please check output argument (Should be like '-csv'): Output=",
				Errors.ERROR_0010.getErrorText());
		assertEquals("Error 0011! Could not get competition results from input.",
				Errors.ERROR_0011.getErrorText());
		assertEquals("Error 0012! Cound not read from DB.",
				Errors.ERROR_0012.getErrorText());
		assertEquals("Error 0013! Cound not close all DB relations.",
				Errors.ERROR_0013.getErrorText());
		assertEquals("Error 0014! Number format is wrong. Try again.",
				Errors.ERROR_0014.getErrorText());
		assertEquals("Error 0015! Date format is frong. Try again.",
				Errors.ERROR_0015.getErrorText());
		assertEquals("Error 0016! Birthday format is wrong in CSV file. Check athlete: ",
				Errors.ERROR_0016.getErrorText());
		assertEquals("Error 0017! Athlete data in CSV not valid at line='",
				Errors.ERROR_0017.getErrorText());
		assertEquals("Error 0018! Could not get data from CSV file.",
				Errors.ERROR_0018.getErrorText());
		assertEquals("Error 0019! Problems closing CSV file.",
				Errors.ERROR_0019.getErrorText());
		assertEquals("Error 0020! Input method is not valid: ",
				Errors.ERROR_0020.getErrorText());
		assertEquals("Error 0021! Could not get data from input.",
				Errors.ERROR_0021.getErrorText());
		assertEquals("Error 0022! Ahtlete result number format is wrong. Result will be set to '0.0'",
				Errors.ERROR_0022.getErrorText());
		assertEquals("Error 0023! Country code does not match pattern. Try again.",
				Errors.ERROR_0023.getErrorText());
		assertEquals("Error 0024! db.properties file not found.",
				Errors.ERROR_0024.getErrorText());
		assertEquals("Error 0025! IO error reading db.priperties.",
				Errors.ERROR_0025.getErrorText());
		assertEquals("Error 0026! No input argument found.",
				Errors.ERROR_0026.getErrorText());
		assertEquals("Error 0027! No output argument found.",
				Errors.ERROR_0027.getErrorText());
		assertEquals("Error 0028! Input or output method is not set.",
				Errors.ERROR_0028.getErrorText());

	}

}
