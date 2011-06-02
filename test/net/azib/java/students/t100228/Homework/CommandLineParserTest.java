package net.azib.java.students.t100228.Homework;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t100228.Homework.CommandLineParser;
import org.junit.Test;

/**
 * Unit tests for the {@link CommandLineParser} class
 * @author Martin
 */
public class CommandLineParserTest {

	/**
	 * Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes the case when there are less
	 * than 2 parameters
	 */
	@Test
	public void constructorArgsLengthLessThanTwo()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "test" });
		assertEquals(false, parser.hasValidArguments());
	}

	/**
	 *  Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes one of the cases when there
	 *  are valid parameters
	 */
	@Test
	public void constructorWithValidParams()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "-console", "-console" });
		assertEquals(true, parser.hasValidArguments());
	}

	/**
	 * Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes the case when input CSV file
	 * is not given
	 */
	@Test
	public void constructorInputFileNotGiven()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "-csv", "-console"});
		assertEquals(false, parser.hasValidArguments());
	}

	/**
	 * Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes the case when output CSV file
	 * is not given
	 */
	@Test
	public void constructorOutputFileNotGiven1()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "-console", "-csv"});
		assertEquals(false, parser.hasValidArguments());
	}

	/**
	 * Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes the case when output HTML
	 * file is not given
	 */
	@Test
	public void constructorOutputFileNotGiven2()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "-console", "-html"});
		assertEquals(false, parser.hasValidArguments());
	}

	/**
	 * Test for the method {@link CommandLineParser#CommandLineParser(String[])}. Executes the case when output XML file
	 * is not given
	 */
	@Test
	public void constructorOutputFileNotGiven3()
	{
		CommandLineParser parser = new CommandLineParser(new String[] { "-console", "-xml"});
		assertEquals(false, parser.hasValidArguments());
	}
}