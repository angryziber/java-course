package net.azib.java.students.t107110.homework;

import org.junit.Test;

import java.io.IOException;

import static net.azib.java.students.t107110.homework.Utils.getObjectFolder;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParserTest {
	@Test(expected = DecathlonException.class)
	public void failWithNoArguments() throws IOException, DecathlonException {
		new CommandLineParser();
	}

	@Test(expected = DecathlonException.class)
	public void failWithInputButNoOutput() throws IOException, DecathlonException {
		new CommandLineParser("-console");
	}

	@Test(expected = DecathlonException.class)
	public void failWithWrongInput() throws IOException, DecathlonException {
		new CommandLineParser("-unknown", "-console");
	}

	@Test(expected = DecathlonException.class)
	public void failWithWrongOutput() throws IOException, DecathlonException {
		new CommandLineParser("-console", "-unknown");
	}

	@Test(expected = DecathlonException.class)
	public void failWithTooManyArguments() throws IOException, DecathlonException {
		new CommandLineParser("-console", "-console", "-console");
	}

	@Test
	public void checkConsoleInputAndOutput() throws IOException, DecathlonException {
		final CommandLineParser parser = new CommandLineParser("-console", "-console");
		assertThat(parser.getReader(), is(instanceOf(ConsoleResultReader.class)));
		assertThat(parser.getWriter(), is(instanceOf(ConsoleResultWriter.class)));
	}

	@Test
	public void checkCSVInputAndOutput() throws IOException, DecathlonException {
		final String testFolder = getObjectFolder(this);
		final CommandLineParser parser =
				new CommandLineParser("-csv", testFolder + "/test.csv", "-csv", testFolder + "/result.csv");
		assertThat(parser.getReader(), is(instanceOf(CSVResultReader.class)));
		assertThat(parser.getWriter(), is(instanceOf(CSVResultWriter.class)));
	}

	@Test
	public void checkDBInput() throws IOException, DecathlonException {
		final CommandLineParser parser = new CommandLineParser("-db", "1", "-console");
		assertThat(parser.getReader(), is(instanceOf(DBResultReader.class)));
	}

	@Test
	public void checkXMLOutput() throws IOException, DecathlonException {
		final CommandLineParser parser = new CommandLineParser("-console", "-xml", "output.xml");
		assertThat(parser.getWriter(), is(instanceOf(XMLResultWriter.class)));
	}

	@Test
	public void checkHTMLOutput() throws IOException, DecathlonException {
		final CommandLineParser parser = new CommandLineParser("-console", "-html", "output.html");
		assertThat(parser.getWriter(), is(instanceOf(HTMLResultWriter.class)));
	}
}
