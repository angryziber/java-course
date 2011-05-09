package net.azib.java.students.t107110.homework;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParserTest {
	@Test(expected = IllegalArgumentException.class)
	public void failWithNoArguments() {
		new CommandLineParser();
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithInputButNoOutput() {
		new CommandLineParser("-console");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithWrongInput() {
		new CommandLineParser("-unknown", "-console");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithWrongOutput() {
		new CommandLineParser("-console", "-unknown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void failWithTooManyArguments() {
		new CommandLineParser("-console", "-console", "-console");
	}

	@Test
	public void checkConsoleInputAndOutput() {
		final CommandLineParser parser = new CommandLineParser("-console", "-console");
		assertThat(parser.getReader(), is(instanceOf(ConsoleResultReader.class)));
		assertThat(parser.getWriter(), is(instanceOf(ConsoleResultWriter.class)));
	}

	@Test
	public void checkCSVInputAndOutput() {
		final CommandLineParser parser = new CommandLineParser("-csv", "input.csv", "-csv", "output.csv");
		assertThat(parser.getReader(), is(instanceOf(CSVResultReader.class)));
		assertThat(parser.getWriter(), is(instanceOf(CSVResultWriter.class)));
	}

	@Test
	public void checkDBInput() {
		final CommandLineParser parser = new CommandLineParser("-db", "1", "-console");
		assertThat(parser.getReader(), is(instanceOf(DBResultReader.class)));
	}

	@Test
	public void checkXMLOutput() {
		final CommandLineParser parser = new CommandLineParser("-console", "-xml", "output.xml");
		assertThat(parser.getWriter(), is(instanceOf(XMLResultWriter.class)));
	}

	@Test
	public void checkHTMLOutput() {
		final CommandLineParser parser = new CommandLineParser("-console", "-html", "output.html");
		assertThat(parser.getWriter(), is(instanceOf(HTMLResultWriter.class)));
	}
}
