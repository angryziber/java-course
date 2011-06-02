package net.azib.java.students.t100228.Homework;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t100228.Homework.InputOutputParams;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Unit test for the {@link InputOutputParams} class
 * @author Martin
 */
public class InputOutputParamsTest {
	/**
	 * Test for the method {@link InputOutputParams#setInputFilePath(String)}. Tests if the class throws an exception
	 * in case of a nonexistent file path.
	 */
	@Test
	public void setInputFilePathWithNonexistentFile()
	{
		InputOutputParams params = new InputOutputParams();
		boolean exceptionThrown = false;
		try
		{
			params.setInputFilePath("nonexistentFile.csv");
		}
		catch(FileNotFoundException ex)
		{
			exceptionThrown = true;
		}
		assertEquals(true, exceptionThrown);
	}
}
