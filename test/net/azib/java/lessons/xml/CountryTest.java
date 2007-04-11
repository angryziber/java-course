package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.custommonkey.xmlunit.Validator;
import org.junit.Before;
import org.junit.Test;

/**
 * CountryTest
 *
 * @author anton
 */
public class CountryTest {
	
	private String xml;
	
	@Before
	public void readXML() throws IOException {
		InputStream in = getClass().getResourceAsStream("country.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder xml = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			xml.append(line).append('\n');
		}
		this.xml = xml.toString();
		reader.close();
	}

	@Test
	public void testValid() throws Exception {
//		Validator v = new Validator(new InputStreamReader(getClass().getResourceAsStream("country.xml")));
//		v.useXMLSchema(true);
//		assertXMLValid(xml);
	}
	
	@Test
	public void testXPath() throws Exception {
		assertXpathEvaluatesTo("Estonia", "", xml);
	}
}
