package net.azib.java.students.t103784.homework;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.List;

public class HTMLOutputTest extends Output {
	@org.junit.Test
	public void testXMLOutput () {
		List<Athlete> contestants;
		Input input = new Input();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src\\net\\azib\\java\\students\\t103784\\homework\\tests\\CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Test input failed (no such test file)");
		}
		contestants = input.readAthleteFromCSV(reader);
		try {
			outputToHTML(contestants);
		} catch (IOException e) {
			System.out.println("Test output failed (IOException)");
		} catch (ParserConfigurationException e) {
			System.out.println("Test output failed (ParserConfException)");
		} catch (TransformerException e) {
			System.out.println("Test output failed (TransformerException)");
		} catch (SAXException e) {
			System.out.println("Test output failed (SAXException)");
		}
	}
}
