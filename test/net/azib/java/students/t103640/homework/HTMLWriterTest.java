package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

public class HTMLWriterTest {
	/**
	 *  Tests if writing out to HTML file works. Although best test is visual confirmation.
	 * @throws ParseException  when creating fake athlete
	 */
	@Test
	public void writeHTMLTest() throws ParseException {
		ArrayList<Athlete> fakeAthletes = new CSVWriterTest().createFakeAthleteList();
		String filepath = "testForHtmlWriter.html";

		DataToHTMLWriter htmlWriter = new DataToHTMLWriter();

		htmlWriter.writeDataToHTML(fakeAthletes, filepath);
		assertTrue(new File(filepath).exists());
	    assertTrue(new File("outputForHtml.xml").exists());

		CSVReader reader =  new CSVReader();

		ArrayList<String> data = reader.readInData("outputForHtml.xml");
		assertTrue(data.toString().contains("Taavi"));
		assertTrue(data.toString().contains("James"));
		assertTrue(data.toString().contains("US"));
		assertTrue(data.toString().contains("EE"));


	}

}
