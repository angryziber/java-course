package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

public class XMLWriterTest {
	/**
	 * Tests if XMLWriter works
	 * @throws ParseException may throw it when something goes wrong with fake athlete creation
	 */
	@Test
	public void writeToXMLTest() throws ParseException {
		ArrayList<Athlete> fakeAthletes = new CSVWriterTest().createFakeAthleteList();

		DataToXMLWriter xmlWriter = new DataToXMLWriter();
		String filename = "testXML.xml";
		xmlWriter.writeDataToXml(fakeAthletes, filename);

		assertTrue(new File(filename).exists());

		 CSVReader reader = new CSVReader();
		ArrayList<String> data =  reader.readInData(filename);

		 assertTrue(!data.isEmpty());
		 assertTrue(data.size() == 2);
		 assertTrue(data.toString().contains("Taavi"));
		 assertTrue(data.toString().contains("James"));


	}


}
