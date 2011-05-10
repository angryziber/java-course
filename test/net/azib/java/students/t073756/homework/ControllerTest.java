package net.azib.java.students.t073756.homework;

import net.azib.java.students.t073756.homework.io.*;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class ControllerTest {
	private Controller c = new Controller();

	@Test
	public void testDoService() throws Exception {
		File file = TestHelper.createTempFile();
		FileUtils.write(file, TestHelper.legalCsvLine);

		c.doService(new String[]{"-csv", file.getAbsolutePath(), "-csv", file.getAbsolutePath()});

		String fileContent = TestHelper.getFileContent(file);
		assertEquals("1,4234," + TestHelper.legalCsvLine, fileContent);
	}

	@Test(expected = DecathlonException.class)
	public void testNoArguments() throws Exception {
		c.validateArgumentsAmount(new String[0]);
	}

	@Test(expected = DecathlonException.class)
	public void testTooMuchArguments() throws Exception {
		c.validateArgumentsAmount(new String[]{"1", "2", "3", "4", "5"});
	}

	@Test
	public void testEnoughArguments() throws Exception {
		try {
			c.validateArgumentsAmount(new String[]{"1", "2"});
			c.validateArgumentsAmount(new String[]{"1", "2", "3"});
			c.validateArgumentsAmount(new String[]{"1", "2", "3", "4"});
		} catch (DecathlonException e) {
			fail("2-4 must should be OK");
		}
	}

	@Test
	public void testCreateDBInput() throws Exception {
		assertInput(DbInputProcessor.class, "-db", "1","-console");
	}

	@Test
	public void testCreateCSVInput() throws Exception {
		assertInput(CsvProcessor.class, "-csv", "home/csv.csv","-console");
	}

	@Test
	public void testCreateConsoleInput() throws Exception {
		assertInput(ConsoleProcessor.class, "-console","-console");
	}

	@Test
	public void testCreateCsvOutput() throws Exception {
		assertOutput(CsvOutput.class, "-console", "-csv", "home/csv.csv");
	}

	@Test
	public void testCreateXMLOutput() throws Exception {
		assertOutput(XmlOutput.class, "-console", "-xml", "home/xml.xml");
	}

	@Test
	public void testCreateHTMLOutput() throws Exception {
		assertOutput(HtmlOutput.class, "-console", "-html", "home/html.html");
	}

	@Test
	public void testCreateConsoleOutput() throws Exception {
		assertOutput(ConsoleOutput.class, "-console", "-console");
	}

	private void assertInput(Class expectedInput, String... args) {
		c.setIO(args);
		assertEquals(expectedInput, c.getInputProcessor().getClass());
	}

	private void assertOutput(Class expectedOutput, String... args) {
		c.setIO(args);
		assertEquals(expectedOutput, c.getOutputProvider().getClass());
	}
}
